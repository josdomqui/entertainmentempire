package aiss.model.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resource.SpotifyResource;
import aiss.model.spotify.Playlists;;

public class SpotifyTest {

		
		private static final String access_token = "BQC8fAHFDUVF87aSFazWlAVXH7-BMtu9h2T7bEb2XZVt6D7MhMM2uVqxACiIILTFor6nkMXaT3Va7wz3slItKc8naskzxfUBVCmEXTEsOh_p6d1_yfTSbDfKelAM1RUlTefzW7EeWysdRPLi_oDx9XwrP_mtzscJhrEj1lKrOUfYFHbNZkAkbLXib40";
		@Test
		public void PlaylistsTest() throws UnsupportedEncodingException {
			SpotifyResource spotify = new SpotifyResource(access_token); //Resource con el propio token incorporado
			Playlists res = spotify.getPlaylists();
			
			assertNotNull("The search returned null", res);
			assertNotNull("The search returned null", res.getItems());
			assertFalse("The number of files is zero", res.getItems().size()==0);
			
			System.out.println("Ejecutado correctamente. Encontrados " + res.getItems().size() + " playlists.");
			
			// Optional: Print movies data
			
			System.out.println("Primer playlist: " + res.getItems().get(0).getName() + ".");
		}

	}
	
	

