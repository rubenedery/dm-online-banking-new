package fr.esipe.dataaccess.account.services;

import fr.esipe.dataaccess.account.entities.AccountEntity;
import fr.esipe.dataaccess.account.models.AccountDto;
import fr.esipe.dataaccess.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 03/11/2017.
 */
@Service
public class AccountService implements IAccountService{
	
	private final AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public List<AccountDto> getAll() {
		
		return accountRepository.findAll()
					   .stream()
					   .map(
							   u -> AccountDto.builder()
											.id(String.valueOf(u.getId()))
											.userEntity(u.getUser())
											.typeAccount(u.getTypeAccount())
											.amount(u.getAmount())
											.build()
					   )
					   .collect(Collectors.toList());

	}
	
	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Optional<AccountDto> getUserById(String id) {
		AccountEntity accountEntity = accountRepository.findOne(Long.parseLong(id));
		return (accountEntity != null) ?
					   Optional.of(
							   AccountDto.builder()
									   .id(String.valueOf(accountEntity.getId()))
									   .typeAccount(accountEntity.getTypeAccount())
									   .userEntity(accountEntity.getUser())
									   .build()
					   )
					   : Optional.empty();

		}
	
	@Override
	public AccountDto create(AccountDto accountDto) {
		return null;
	}
	
	@Override
	public void delete(String id) {
		
	}
	
	@Override
	public void update(String id, AccountDto accountDto) {
		
	}
}
