package fr.ekinci.clientmanagement.user.controllers;

import fr.esipe.restclientutils.RestClientManagement;
import models.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	/**
	 * Get a client
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") long id) {
		UserDto userDto = RestClientManagement.listOne(
				"users", id, UserDto.class);
		return !(userDto == null) ?
					   new ResponseEntity<>(userDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * This methode create a client
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
		
		UserDto userDto = RestClientManagement.create("users", UserDto.class ,user);
		
		return !(userDto == null) ?
					   new ResponseEntity<>(userDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * This methode update a client
	 * @param id
	 * @param user
	 * @return
	 */
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody UserDto user) {
		RestClientManagement.update("users",user,id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
