package fr.esipe.dataaccess.user.models;

import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @author Gokan EKINCI
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private String lastName;
	private String firstName;
	private String phone;
	private String address;
	private Date age;
	List<AccountDto> accountDtoList;
}
