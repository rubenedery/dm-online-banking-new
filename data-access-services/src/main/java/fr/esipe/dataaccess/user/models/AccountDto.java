package fr.esipe.dataaccess.user.models;

import fr.esipe.dataaccess.user.entities.UserEntity;
import lombok.*;

import javax.validation.constraints.Pattern;

/**
 * @author RubenEdery on 03/11/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private UserDto userDto;
	private TypeAccount typeAccount;
	private double amount;
	private double amount_discovered_max;
	
}
