package fr.esipe.dataaccess.account.controllers;



import fr.esipe.dataaccess.account.models.AccountDto;
import fr.esipe.dataaccess.account.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 03/11/2017.
 */
@RestController
@RequestMapping(path = "/account")
public class AccountController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.create(accountDto), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getall")
	public ResponseEntity<?> getAllAccount() {
		
		final List<AccountDto> listAccountDto = accountService.getAll();
		
		return (!listAccountDto.isEmpty()) ?
					   new ResponseEntity<>(listAccountDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccountDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		// TODO
		final Optional<AccountDto> dtoOpt = accountService.getUserById(id);
		return (dtoOpt.isPresent()) ?
					   new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
