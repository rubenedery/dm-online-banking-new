package fr.esipe.dataaccess.user.models;

import lombok.*;

/**
 * @author RubenEdery on 07/11/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
	private long idTransaction;
	private float amount;
}
