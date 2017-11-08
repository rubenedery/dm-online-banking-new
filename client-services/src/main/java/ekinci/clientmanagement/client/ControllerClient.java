package ekinci.clientmanagement.client;

import fr.esipe.restclientutils.RestClient;
import models.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/client")
public class ControllerClient {
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountDto> create(@RequestBody AccountDto user) {
		
		AccountDto accountDto = RestClient.create("account", AccountDto.class ,user);
		
		return !(accountDto == null) ?
					   new ResponseEntity<>(accountDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
