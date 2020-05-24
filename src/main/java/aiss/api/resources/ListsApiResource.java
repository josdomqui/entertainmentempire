package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorNameLists;
import aiss.api.resources.comparators.ComparatorNameListsReversed;
import aiss.model.Film;
import aiss.model.Lists;
import aiss.model.repository.EERepository;
import aiss.model.repository.MapEERepository;

@Path("/lists")
public class ListsApiResource {
	
	/* Singleton */
	private static ListsApiResource _instance=null;
	EERepository repository;
	
	private ListsApiResource() {
		repository=MapEERepository.getInstance();

	}
	
	public static ListsApiResource getInstance()
	{
		if(_instance==null)
				_instance=new ListsApiResource();
		return _instance;
	}
	
	// Metodo que devuelve una lista de todas las listas existentes, pudiendo filtrar por título con el parámetro 'q' y ordenando con el parámetro 'order'
    @GET
    @Produces("application/json")
    public Collection<Lists> getAllLists(@QueryParam("order") String order,
            @QueryParam("isEmpty") Boolean isEmpty, @QueryParam("q") String title)
    {
        List<Lists> result = new ArrayList<Lists>();
            
        for (Lists list: repository.getAllLists()) {
            if (title == null || list.getListTitle().toLowerCase().contains(title)) { // Name filter
                if (isEmpty == null // Empty list filter
                        || (isEmpty && (list.getFilms() == null || list.getFilms().size() == 0))
                        || (!isEmpty && (list.getFilms() != null && list.getFilms().size() > 0))) {
                    result.add(list);
                }
            }
        }
            
        if (order != null) { // Order results
            if (order.equals("name")) {
                Collections.sort(result, new ComparatorNameLists());
            } else if (order.equals("-name")) {
                Collections.sort(result, new ComparatorNameListsReversed());
            } else {
                throw new BadRequestException("The order parameter must be 'name' or '-name'.");
            }
        }

        return result;
    }
	
	
    // Metodo que devuelve una determinada lista a partir de un id
	@GET
	@Path("/{listId}")
	@Produces("application/json")
	public Lists getListById(@PathParam("listId") String listId)
	{
		Lists list = repository.getListById(listId);
		
		if (list == null) {
			throw new NotFoundException("The list with id="+ listId +" was not found");			
		}
		
		return list;
	}
	
	
	// Metodo que crea una lista
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addList(@Context UriInfo uriInfo, Lists l) {
		if (l.getListTitle() == null || "".equals(l.getListTitle()))
			throw new BadRequestException("The title of the list must not be null");
		
		if (l.getFilms()!=null)
			throw new BadRequestException("The films property is not editable.");

		repository.addList(l);

		// Builds the response. Returns the list the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(l.getListId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(l);			
		return resp.build();
	}


	// Metodo que actualiza una lista
	@PUT
	@Consumes("application/json")
	public Response updateList(Lists list) {
		Lists oldlist = repository.getListById(list.getListId());
		if (oldlist == null) {
			throw new NotFoundException("The list with id="+ list.getListId() +" was not found");			
		}
		
		if (list.getFilms()!=null)
			throw new BadRequestException("The films property is not editable.");
		
		// Update list title
		if (list.getListTitle()!=null)
			oldlist.setListTitle(list.getListTitle());
		
		// Update content
		if (list.getListDescription()!=null)
			oldlist.setListDescription(list.getListDescription());
		
		return Response.noContent().build();
	}
	
	
	// Metodo que borra una lista a partir de un id
	@DELETE
	@Path("/{listId}")
	public Response deleteList(@PathParam("listId") String listId) {
		Lists toberemoved=repository.getListById(listId);
		if (toberemoved == null)
			throw new NotFoundException("The list with id="+ listId +" was not found");
		else
			repository.deleteList(listId);
		
		return Response.noContent().build();
	}
	
	
	// Metodo que añade una pelicula a una lista a partir del id de la lista y el id de la pelicula
	@POST	
	@Path("/{listId}/{filmId}")
	@Produces("application/json")
	public Response addFilm(@Context UriInfo uriInfo,@PathParam("listId") String listId, @PathParam("filmId") String filmId)
	{				
		
		Lists l = repository.getListById(listId);
		Film film = repository.getFilmById(filmId);
		
		if (l==null)
			throw new NotFoundException("The list with id=" + listId + " was not found");
		
		if (film == null)
			throw new NotFoundException("The film with id=" + filmId + " was not found");
		
		if (l.getFilm(filmId)!=null)
			throw new BadRequestException("The film is already included in the list.");
			
		repository.addFilm(listId, filmId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(listId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(l);			
		return resp.build();
	}
	
	
	// Metodo que borra una pelicula de una lista a partir del id de la lista y el id de la pelicula
	@DELETE
	@Path("/{listId}/{filmId}")
	public Response removeFilm(@PathParam("listId") String listId, @PathParam("filmId") String filmId) {
		Lists list = repository.getListById(listId);
		Film film = repository.getFilmById(filmId);
		
		if (list==null)
			throw new NotFoundException("The list with id=" + listId + " was not found");
		
		if (film == null)
			throw new NotFoundException("The film with id=" + filmId + " was not found");
		
		
		repository.removeFilm(listId, filmId);		
		
		return Response.noContent().build();
	}
}