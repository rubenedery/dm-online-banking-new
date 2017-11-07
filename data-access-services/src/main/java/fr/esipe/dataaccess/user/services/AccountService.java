package fr.esipe.dataaccess.user.services;

import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.models.AccountDto;
import fr.esipe.dataaccess.user.models.UserDto;
import fr.esipe.dataaccess.user.repositories.AccountRepository;
import fr.esipe.dataaccess.user.repositories.UserRepository;
import org.apache.tomcat.jni.Local;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 03/11/2017.
 */
@Service
public class AccountService implements IAccountService{
	
	private final AccountRepository accountRepository;
	private final UserService userService;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Autowired
	public AccountService(AccountRepository accountRepository, UserService userService) {
		
		this.accountRepository = accountRepository;
		this.userService=userService;
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
											//.userEntity(u.getUserEntity())
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
	public Optional<AccountDto> getAccountById(String id) {
		AccountEntity accountEntity = accountRepository.findOne(Long.parseLong(id));
		return (accountEntity != null) ?
					   Optional.of(
							   AccountDto.builder()
									   .id(String.valueOf(accountEntity.getId()))
									   .typeAccount(accountEntity.getTypeAccount())
									//   .userEntity(accountEntity.getUserEntity())
									   .build()
					   )
					   : Optional.empty();
		
	}
	
	@Override
	public AccountDto create(AccountDto accountDto) throws Exception {
		
		Calendar curr = Calendar.getInstance();
		
		List<AccountDto> accountDtoList = getAll();
		List<UserDto> userDtoList = userService.getAll();
		int i =0;
		int j =0;
		while(i<accountDtoList.size()) {
			if (accountDtoList.get(i).getTypeAccount().equals(accountDto.getTypeAccount())) {
				throw new Exception("Compte dupliqué.");
			}
		}
		while(j<userDtoList.size()){
			 if(calculateAge(userDtoList.get(i).getAge())<18){
				throw new Exception("Cet individu est mineur.");
			}
		}
		
		AccountEntity userEntity = accountRepository.save(mapper.map(accountDto,AccountEntity.class));
		return mapper.map(userEntity,AccountDto.class);
	}
	
	@Override
	public void delete(String id) {
		
	}
	
	@Override
	public void update(String id, AccountDto accountDto) {
		
	}
	
	
	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate=LocalDate.now();
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}
	
	
}
