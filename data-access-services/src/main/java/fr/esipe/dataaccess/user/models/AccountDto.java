package fr.esipe.dataaccess.user.models;

import fr.esipe.dataaccess.user.entities.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;

/**
 * @author RubenEdery on 03/11/2017.
 */
@Data
@Builder
@ToString
public class AccountDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private UserEntity userEntity;
	private TypeAccount typeAccount;
	private double amount;
}
