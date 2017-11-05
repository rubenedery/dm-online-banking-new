package fr.esipe.dataaccess.account.services;

import fr.esipe.dataaccess.account.models.AccountDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 03/11/2017.
 */
public interface IAccountService {
	
	List<AccountDto> getAll();
	
	Optional<AccountDto> getUserById(String id);
	
	AccountDto create(AccountDto accountDto);
	
	void delete(String id);
	
	void update(String id, AccountDto accountDto);
	
	
}
