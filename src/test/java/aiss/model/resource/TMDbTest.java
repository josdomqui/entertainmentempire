package aiss.model.resource;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import aiss.model.HBO.HBOSearch;

import aiss.model.resource.TMDbResource;

public class TMDbTest {

	@Test
	public void getMoviesTest() throws UnsupportedEncodingException {
		String title = "Gladiator";
		String queryFormatted = URLEncoder.encode(title, "UTF-8");
		TMDbResource tmdb = new TMDbResource();
		HBOSearch tmdbResults = tmdb.getMovies(queryFormatted);
		
		assertNotNull("The search returned null", tmdbResults);
		assertNotNull("The search returned null", tmdbResults.getResults());
		assertFalse("The number of films of " + title + " is zero", tmdbResults.getTotalResults() == 0);
		
		System.out.println("The search for " + title + "'s films returned " + tmdbResults.getTotalResults() + " movies.");
		
		// Optional: Print movies data
		
		System.out.println("First result for your search: " + tmdbResults.getResults().get(0).getTitle() + ".");
	}

}
