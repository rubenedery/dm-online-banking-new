package fr.ekinci.controllers;

import fr.esipe.dataaccess.user.controllers.UserController;
import fr.esipe.dataaccess.user.services.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @author RubenEdery on 06/11/2017.
 */
public class UserControllerTest {
	
	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
}
