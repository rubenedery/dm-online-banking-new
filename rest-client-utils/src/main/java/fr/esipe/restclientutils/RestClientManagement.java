package fr.esipe.restclientutils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author RubenEdery on 05/11/2017.
 */
public class RestClientManagement {
	
	/**
	 * Inspired by this website :
	 * https://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
	 */
	
	
	/**
	 * The Client management can't delete an use so the methode isn't present here
	 * He can update, create and see information about users.
	 */
	public static final String REST_SERVICE_URI = "http://localhost:25002/data-access/";
	
	public static <T> T listOne(String endPath,
								long id,
								Class<T> generic){
		
		final String url = REST_SERVICE_URI + "/" + endPath + "/" +id;
		RestTemplate restTemplate2 = new RestTemplate();
		T result = restTemplate2.getForObject(url,generic);
		return result;
	}
	
	/**
	 *
	 * @param endPath
	 * @param generic
	 * @param object
	 * @param <T>
	 * @return
	 */
	public static <T> T create(String endPath,
							   Class<T> generic,
							   T object ) {
		final String url = REST_SERVICE_URI + "/" + endPath + "/";
		RestTemplate restTemplate = new RestTemplate();
		T resultObject = restTemplate.postForObject( url,object,generic);
		return resultObject;
		
	}
	
	/**
	 *
	 * @param endPath
	 * @param object
	 * @param id
	 * @param <T>
	 */
	public static <T> void update (String endPath,
								   T object,long id){
		
		final String url = REST_SERVICE_URI + "/" + endPath + "/" + id;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url,object);
		
	}
	
}
