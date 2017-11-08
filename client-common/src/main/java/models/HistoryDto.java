package models;

import lombok.*;

import java.util.Date;

/**
 * @author RubenEdery on 05/11/2017.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistoryDto {
	
	private long id;
	private AccountDto accountDto;
	private float amount;
	private Date datetransaction;
	
}
