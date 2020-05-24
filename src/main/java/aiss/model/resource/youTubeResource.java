package aiss.model.resource;

import java.io.*;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.youtube.VideoSearch;

public class youTubeResource {
	
	private static final String YOUTUBE_API_KEY = "AIzaSyAuRogweLPF8pEHvY7in6ajV53r9tihp-U";
	private static final Logger log = Logger.getLogger(youTubeResource.class.getName());
	
	public VideoSearch getVideo(String query) throws UnsupportedEncodingException {
		String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=trailer+" + URLEncoder.encode(query, "UTF-8") + "&country=es&key="+ YOUTUBE_API_KEY;
		log.log(Level.FINE, "YouTube URI: " +  uri);
		
		ClientResource cr = new ClientResource(uri);
		VideoSearch youTubeSearch = cr.get(VideoSearch.class);
		
		return youTubeSearch;
				
	}
}
