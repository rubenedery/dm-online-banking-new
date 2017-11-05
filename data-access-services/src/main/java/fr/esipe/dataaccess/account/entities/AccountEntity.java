package fr.esipe.dataaccess.account.entities;

import fr.esipe.dataaccess.account.models.TypeAccount;
import fr.esipe.dataaccess.user.entities.UserEntity;
import lombok.Data;

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
	private UserEntity user;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "typeaccount")
	private TypeAccount typeAccount;
}
		
		