package fr.ekinci.controllers;

import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.models.AccountDto;
import fr.esipe.dataaccess.user.models.TypeAccount;
import fr.esipe.dataaccess.user.repositories.AccountRepository;
import fr.esipe.dataaccess.user.services.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 07/11/2017.
 */
public class AccountServiceTest {
	
	
	@InjectMocks AccountService accountService;
	
	@Mock AccountRepository accountRepository;
	
	List<AccountEntity> accountEntityList;
	AccountEntity accountEntity;
	
	@Before public void init(){
		
		MockitoAnnotations.initMocks(this);
		
		 accountEntity = new AccountEntity();
		 accountEntity.setId(Long.parseLong("1"));
		 accountEntity.setAmount(123);
		 accountEntity.setTypeAccount(TypeAccount.CCP);
		 
		 //Add accountEntity to new List
		 accountEntityList = new ArrayList<AccountEntity>();
		 accountEntityList.add(accountEntity);
	}
	
	
	@Test public void getAllTest(){
		Mockito.when(accountRepository.findAll()).thenReturn(accountEntityList);
		List<AccountDto> l = accountService.getAll();
		Assert.assertTrue(l.get(0).getId().equals("1"));
	}
	
	@Test public void getAllTestWrong(){
		Mockito.when(accountRepository.findAll()).thenReturn(accountEntityList);
		List<AccountDto> l = accountService.getAll();
		Assert.assertFalse(l.get(0).getId().equals("144"));
	}
	
	@Test public void getAccountByIdTestWrong(){
		Mockito.when(accountRepository.findOne(Mockito.anyLong())).thenReturn(accountEntity);
		Optional<AccountDto> o = accountService.getAccountById("1");
		Assert.assertFalse(o.get().getTypeAccount().equals(TypeAccount.LDD));
	}
	
	@Test public void getAccountByIdTest(){
		Mockito.when(accountRepository.findOne(Mockito.anyLong())).thenReturn(accountEntity);
		Optional<AccountDto> o = accountService.getAccountById("1");
		Assert.assertTrue(o.get().getTypeAccount().equals(TypeAccount.CCP));
	}
	
}
