package redery.models;

//import fr.ekinci.clientmanagement.user.models.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author RubenEdery on 05/11/2017.
 */
@Data
@Builder
@ToString
public class AccountDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String idAccount;
//	private UserDto client;
}
