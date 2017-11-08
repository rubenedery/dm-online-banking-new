package fr.esipe.dataaccess.user.entities;

import lombok.Data;
import models.TypeAccount;

import javax.persistence.*;

/**
 * @author RubenEdery on 05/11/2017.
 */

@Data
@Entity(name = "account")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private UserEntity userEntity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "typeaccount")
	private TypeAccount typeAccount;
	
}
		
		