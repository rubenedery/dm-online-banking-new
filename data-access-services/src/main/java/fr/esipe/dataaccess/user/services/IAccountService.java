package fr.esipe.dataaccess.user.services;

import models.AccountDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 03/11/2017.
 */
public interface IAccountService {
	
	List<AccountDto> getAll();
	
	Optional<AccountDto> getAccountById(String id);
	
	AccountDto create(AccountDto accountDto) throws Exception;
	
	void delete(String id);
	
	void update(String id, AccountDto accountDto);
	
	
}
