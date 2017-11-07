package fr.esipe.restclientutils;

import org.springframework.web.client.RestTemplate;

/**
 * @author RubenEdery on 05/11/2017.
 */
public class RestClient {
	
	public static final String REST_SERVICE_URI = "http://localhost:25002/data-access/";
	
	public static <T> T create(String endPath,
							   Class<T> generic,
							   T object ) {
		final String url = REST_SERVICE_URI + "/" + endPath + "/";
		RestTemplate restTemplate = new RestTemplate();
		T resultObject = restTemplate.postForObject( url,object,generic);
		return resultObject;
		
	}
	
}
