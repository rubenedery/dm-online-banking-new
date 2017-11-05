package fr.ekinci.clientmanagement.user.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "banking")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
}