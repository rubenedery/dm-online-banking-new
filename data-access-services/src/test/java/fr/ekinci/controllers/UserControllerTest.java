package fr.ekinci.controllers;

import fr.esipe.dataaccess.user.controllers.UserController;
import fr.esipe.dataaccess.user.models.UserDto;
import fr.esipe.dataaccess.user.services.UserService;
import org.apache.catalina.filters.CorsFilter;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author RubenEdery on 06/11/2017.
 */

public class UserControllerTest {
	/*
	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext wac;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
	}
	
	@Test
	public void getController() throws Exception {

		Date d = new Date();
		
		UserDto u = new UserDto("1",
									   "Ruben",
									   "Edery",
									   "0987654",
									   "Adresse de rue",
									   	d,
									   null);
		List<UserDto> newList =new List<UserDto>() {
			@Override
			public int size() {
				return 0;
			}
			
			@Override
			public boolean isEmpty() {
				return false;
			}
			
			@Override
			public boolean contains(Object o) {
				return false;
			}
			
			@Override
			public Iterator<UserDto> iterator() {
				return null;
			}
			
			@Override
			public Object[] toArray() {
				return new Object[0];
			}
			
			@Override
			public <T> T[] toArray(T[] a) {
				return null;
			}
			
			@Override
			public boolean add(UserDto userDto) {
				return false;
			}
			
			@Override
			public boolean remove(Object o) {
				return false;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				return false;
			}
			
			@Override
			public boolean addAll(Collection<? extends UserDto> c) {
				return false;
			}
			
			@Override
			public boolean addAll(int index, Collection<? extends UserDto> c) {
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				return false;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				return false;
			}
			
			@Override
			public void clear() {
				
			}
			
			@Override
			public UserDto get(int index) {
				return null;
			}
			
			@Override
			public UserDto set(int index, UserDto element) {
				return null;
			}
			
			@Override
			public void add(int index, UserDto element) {
				
			}
			
			@Override
			public UserDto remove(int index) {
				return null;
			}
			
			@Override
			public int indexOf(Object o) {
				return 0;
			}
			
			@Override
			public int lastIndexOf(Object o) {
				return 0;
			}
			
			@Override
			public ListIterator<UserDto> listIterator() {
				return null;
			}
			
			@Override
			public ListIterator<UserDto> listIterator(int index) {
				return null;
			}
			
			@Override
			public List<UserDto> subList(int fromIndex, int toIndex) {
				return null;
			}
		};
		
		newList.add(u);
		
		
		Mockito.when(userService.getAll()).thenReturn(newList);
		
		/*mockMvc.perform(get("/getall"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", IsCollectionWithSize.hasSize(0)))
				.andExpect(jsonPath("$[0].id", Is.is("1")))
				.andExpect(jsonPath("$[0].lastname", Is.is("Ruben")))
				.andExpect(jsonPath("$[0].firstName", Is.is("Edery")))
				.andExpect(jsonPath("$[0].phonr", Is.is("0987654")))
				.andExpect(jsonPath("$[0].address", Is.is("Adresse de rue")));
		Mockito.verify(userService, Mockito.times(1)).getAll();
		Mockito.verifyNoMoreInteractions(userService);
		*/
		
	
	

	
	
	
}
