package fr.ekinci.controllers;

import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.entities.UserEntity;
import fr.esipe.dataaccess.user.models.TypeAccount;
import fr.esipe.dataaccess.user.models.UserDto;
import fr.esipe.dataaccess.user.repositories.UserRepository;
import fr.esipe.dataaccess.user.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 07/11/2017.
 */
public class UserServiceTest {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	UserEntity userEntity;
	UserEntity userEntity2;
	
	List<UserEntity> listuserentity;
	
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		userEntity = new UserEntity();
		userEntity2 = new UserEntity();
		listuserentity = new ArrayList<UserEntity>();
		
		userEntity.setFirstName("Ruben");
		userEntity.setPhone("0987654321");
		userEntity.setAddress("1 rue victor hugo");
		
		userEntity2.setFirstName("Gokan");
		userEntity2.setPhone("098123456");
		userEntity2.setAddress("2 rue victor hugo");
		
		listuserentity.add(userEntity);
		listuserentity.add(userEntity2);
		
	}
	
	@Test
	public void getAlltest(){
		Mockito.when(userRepository.findAll()).thenReturn(listuserentity);
		List<UserDto> userDtoList = userService.getAll();
		Assert.assertTrue(userDtoList.get(0).getFirstName().equals("Ruben"));
	}
	
	@Test
	public void getAllTestWrong(){
		Mockito.when(userRepository.findAll()).thenReturn(listuserentity);
		List<UserDto> userDtoList = userService.getAll();
		Assert.assertFalse(userDtoList.get(0).getFirstName().equals("false"));
	}
	
	
	@Test
	public void getUserByIdTest(){
		Mockito.when(userRepository.findOne(Mockito.anyLong())).thenReturn(userEntity);
		Optional<UserDto> userDto = userService.getUserById("1");
		Assert.assertTrue(userDto.get().getPhone().equals("0987654321"));
	}
	
	@Test
	public void getUserByIdTestWrong(){
		Mockito.when(userRepository.findOne(Mockito.anyLong())).thenReturn(userEntity);
		Optional<UserDto> userDto = userService.getUserById("1");
		Assert.assertFalse(userDto.get().getPhone().equals("094321"));
	}
	
	
}
