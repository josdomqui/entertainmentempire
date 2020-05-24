package aiss.model.resource;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import aiss.model.google.drive.Files;
import aiss.model.resource.GoogleDriveResource;

public class GoogleDriveTest {
	
	private static final String access_token = "ya29.a0AfH6SMC26Bzx8H5HYGvd9glId-jVIucHvNnsLaH5QasN_F7rs66E_hRJTe4QkbPhW3g3Fda50aLB3pQ8TH3LxYmiz74dsqWQ5LKuYjkmkhrANd3oQgSABekl0FLgBEOW6QbojcN0NgQDLfU9O7_pVjZ2dSvDdPcEabo" + 
			"";
			
	
	@Test
	public void getFilesTest() throws UnsupportedEncodingException {
		GoogleDriveResource googleDrive = new GoogleDriveResource(access_token); //Resource con el propio token incorporado
		Files res = googleDrive.getFiles();
		
		assertNotNull("The search returned null", res);
		assertNotNull("The search returned null", res.getItems());
		assertFalse("The number of files is zero", res.getItems().size()==0);
		
		System.out.println("Ejecutado correctamente. Encontrados " + res.getItems().size() + " archivos.");
		
		// Optional: Print movies data
		
		System.out.println("Primer archivo en tu drive: " + res.getItems().get(0).getTitle() + ".");
	}

}