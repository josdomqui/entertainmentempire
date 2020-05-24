package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.repository.*;
import aiss.model.Film;



@Path("/films")
public class FilmsApiResource {
	
	/* Singleton */
	private static FilmsApiResource _instance=null;
	EERepository repository;
	
	private FilmsApiResource() {
		repository=MapEERepository.getInstance();

	}
	
	public static FilmsApiResource getInstance()
	{
		if(_instance==null)
				_instance=new FilmsApiResource();
		return _instance;
	}
	
	
	// Metodo que devuelve una lista de todas las peliculas o series, pudiendo filtrar por título con el parámetro 'q'
	@GET
	@Produces("application/json")
	public Collection<Film> getAllFilms(@QueryParam("q") String title) {
		Collection<Film> res = new ArrayList<Film>();
		
		if (title == null) {
			res = repository.getAllFilms();
        } else {
        	res = repository.getFilmsByTitle(title);
        } return res;
	}
	
	
	// Metodo que devuelve una determinada serie o pelicula a partir de un id
	@GET
	@Path("/{filmId}")
	@Produces("application/json")
	public Film getFilmById(@PathParam("filmId") String filmId) {
		Film film = repository.getFilmById(filmId);
		if (film == null) {
			throw new BadRequestException("La película solicitada no existe.");
		}
		return film;
	}
	
	
	// Metodo que crea una pelicula
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createFilm(@Context UriInfo uriInfo, Film film) {
		if (film.getFilmTitle() == null || "".equals(film.getFilmTitle()))
			throw new BadRequestException("The title of the film must not be null");

		repository.addFilm(film);

		// Builds the response. Returns the film has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(film.getFilmId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(film);			
		return resp.build();
	}
	
	
	// Metodo que actualiza una pelicula
	@PUT
	@Consumes("application/json")
	public Response updateFilm(Film film) {
		Film oldfilm = repository.getFilmById(film.getFilmId());
		if (oldfilm == null) {
			throw new NotFoundException("The film with id = "+ film.getFilmId() +" was not found");			
		}
		
		// Update film title
		if (film.getFilmTitle()!=null)
			oldfilm.setFilmTitle(film.getFilmTitle());
		
		// Update synopsis
		if (film.getSynopsis()!=null)
			oldfilm.setSynopsis(film.getSynopsis());
		
		// Update url
		if (film.getUrl()!=null)
			oldfilm.setUrl(film.getUrl());
		
		return Response.noContent().build();
	}
	
	
	// Metodo que borra una pelicula a partir de un id
	@DELETE
	@Path("/{filmId}")
	public Response deleteFilm(@PathParam("filmId") String filmId) {
		Film toberemoved=repository.getFilmById(filmId);
		if (toberemoved == null)
			throw new NotFoundException("The film with id = "+ filmId +" was not found");
		else
			repository.deleteFilm(filmId);
		
		return Response.noContent().build();
	}


}
