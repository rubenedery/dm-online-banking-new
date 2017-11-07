package fr.esipe.dataaccess.user.services;

import fr.esipe.dataaccess.user.entities.UserEntity;
import fr.esipe.dataaccess.user.models.UserDto;
import fr.esipe.dataaccess.user.repositories.UserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {
	/**
	 * Initialize userRepository interface
	 */
	private final UserRepository userRepository;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/**
	 * This functionnality is used when you need information about the totality of users
	 * @return
	 */
	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll()
			.stream()
			.map(
					//This is automapper : Use to mapping different class to another one
					//Website Source : http://www.baeldung.com/dozer
					u -> mapper.map(u, UserDto.class)
			)
			.collect(Collectors.toList());
	}
	
	/**
	 * This functionnality is used when you need to have information about one user
	 * @param id
	 * @return
	 */
	@Override
	public Optional<UserDto> getUserById(String id) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		return (userEntity != null) ?
			Optional.of(
				mapper.map(userEntity, UserDto.class)
			)
			: Optional.empty();
	}
	
	/**
	 * This functionnality is used when you need to create one user
	 * We need to map user entity to user dto and return user dto
	 * @param userDto
	 * @return userDto
	 */
	@Override
	public UserDto create(UserDto userDto) {
		
		UserEntity userEntity = userRepository.save(mapper.map(userDto,UserEntity.class));
		return mapper.map(userEntity,UserDto.class);
		
		/*UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setAddress(userDto.getAddress());
		userEntity.setPhone(userDto.getPhone());
		UserEntity userEntity1 = userRepository.save(userEntity);
		return UserDto.builder()
			.id(String.valueOf(userEntity1.getId()))
			.firstName(userEntity1.getFirstName())
			.lastName(userEntity1.getLastName())
		    .address(userEntity1.getAddress())
		    .phone(userEntity1.getPhone())
		    .accountDtoList(userEntity1.getAccountEntity())
			.build();*/
	}
	
	/**
	 * This functionnality is used when you need to delete one user
	 * @param id
	 */
	@Override
	public void delete(String id) {
		userRepository.delete(Long.parseLong(id));
	}
	
	/**
	 * With this functionnality, you can update data of the database.
	 * But you can change just address and phone because it's a condition of the DM.
	 * @param id
	 * @param userDto
	 */
	@Override
	public void update(String id, UserDto userDto) {
		Optional<UserDto> databaseUser = getUserById(id);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(Long.parseLong(id));
		
		//if you want to change the first name and the last name you can use these codes lines.
		//userEntity.setFirstName(userDto.getFirstName());
		//userEntity.setLastName(userDto.getLastName());
		
		//if you want to keep database data you nee to use these lines of code.
		userEntity.setFirstName(databaseUser.get().getFirstName());
		userEntity.setLastName(databaseUser.get().getLastName());
		
		//If you want to update the adress and the phone you need to use these 2 lines.
		userEntity.setAddress(userDto.getAddress());
		userEntity.setPhone(userDto.getPhone());
		
		//Age cant change
		userEntity.setAge(databaseUser.get().getAge());
		
		userRepository.save(userEntity);
	}
}
