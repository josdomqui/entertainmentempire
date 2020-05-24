package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.HBO.HBOSearch;
import aiss.model.resource.SpotifyResource;
import aiss.model.resource.TMDbResource;
import aiss.model.resource.youTubeResource;
import aiss.model.spotifysearch.AudioSearch;
import aiss.model.youtube.VideoSearch;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String query = request.getParameter("searchQuery");
		String accessToken = (String) request.getSession().getAttribute("Spotify-token");

		// Search for movies in TMDb
		log.log(Level.FINE, "Searching for TMDb movies that contain " + query);
		TMDbResource tmdb = new TMDbResource();
		HBOSearch tmdbResults = tmdb.getMovies(query);
		
		// Search for videos in YouTube
		log.log(Level.FINE, "Searching for videos " + query);
		youTubeResource videos = new youTubeResource();
		VideoSearch videosResults = videos.getVideo(query);

		//Spotify
		log.log(Level.FINE, "Searching for audios " + query);
		if (accessToken != null && !"".equals(accessToken)) {
            SpotifyResource playlists = new SpotifyResource(accessToken);
            AudioSearch playlistsResults = playlists.getPlaylist(query);

            if (tmdbResults.getTotalResults()!=0 && playlistsResults!=null && videos!=null){				
            	request.setAttribute("movies", tmdbResults.getResults());
    			request.setAttribute("videos", videosResults.getItems());
                request.setAttribute("playlists", playlistsResults.getPlaylists().getItems());
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            } else {
                log.log(Level.SEVERE, "Movies object: " + tmdbResults); //playlistResult cambiado "Movies object: " + playlistsResults
                request.getRequestDispatcher("/error.html").forward(request, response);
            }
            
            
        } else {
            log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
            request.getRequestDispatcher("/AuthController/Spotify").forward(request, response);
            }

        }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
