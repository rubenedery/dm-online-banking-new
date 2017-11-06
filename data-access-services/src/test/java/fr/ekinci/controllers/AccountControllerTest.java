package fr.ekinci.controllers;

import fr.esipe.dataaccess.user.controllers.AccountController;
import fr.esipe.dataaccess.user.services.AccountService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @author RubenEdery on 06/11/2017.
 */
public class AccountControllerTest {
	
	
	
	@Mock
	AccountService accountService;
	
	@InjectMocks
	AccountController accountController;
	
	
}
