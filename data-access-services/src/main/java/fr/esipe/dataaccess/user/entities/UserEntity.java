package fr.esipe.dataaccess.user.entities;

import fr.esipe.dataaccess.account.entities.AccountEntity;
import fr.esipe.dataaccess.account.models.AccountDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	
	
}