package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;


import aiss.model.HBO.HBOSearch;

public class TMDbResource {
	private static final String TMDB_API_KEY = "081763eba826e4fa57318cf3c59365af";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(TMDbResource.class.getName());
	
	public HBOSearch getMovies(String query) throws UnsupportedEncodingException {

		// TODO: Perform search in OMDb
		
		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "https://api.themoviedb.org/3/search/multi?api_key=" + TMDB_API_KEY + 
				"&query=" + queryFormatted + "&language=es-ES" + "&include_adult=false"; 
		
		log.log(Level.FINE, "TMDb URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		HBOSearch hboSearch = cr.get(HBOSearch.class);
		
		return hboSearch;
	}

}
