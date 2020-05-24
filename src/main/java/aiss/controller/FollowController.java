package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.SpotifyResource;
import aiss.model.spotifysearch.AudioSearch;

/**
 * Servlet implementation class SearchController
 */
public class FollowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(FollowController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String id = request.getParameter("id");
		String accessToken = (String) request.getSession().getAttribute("Spotify-token");

		//Spotify
		log.log(Level.FINE, "Follow the playlist " + id);
		if (accessToken != null && !"".equals(accessToken)) {
			SpotifyResource spResource = new SpotifyResource(accessToken);
			spResource.followPlaylist(id);
			request.getRequestDispatcher("/spotifyPlaylistsGet").forward(request, response);
            			
            }else {
                 log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
                 request.getRequestDispatcher("/AuthController/Spotify").forward(request, response);
             }
         

        } 
        
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

