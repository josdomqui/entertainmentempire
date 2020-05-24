package aiss.model.resource;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resource.youTubeResource;
import aiss.model.youtube.VideoSearch;

public class YoutubeTests {

	@Test
	public void testGetVideos() throws UnsupportedEncodingException {
		String busqueda = "Peaky";
		youTubeResource youtube = new youTubeResource();
		VideoSearch res = youtube.getVideo(busqueda);

		// La siguiente lÃ­nea es para traducir cuando no hay resultados
		if (res.getItems().isEmpty()) {
			res = null;
		}
		if (res != null) {
			System.out.println("Encontrado Correctamente");
		}

		assertNotNull("La lista de vÃ­deos no puede ser null", res);
		System.out.println("Test YouTube: Probando búsqueda de vídeos de " + busqueda);


	}
}
