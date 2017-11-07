package fr.esipe.dataaccess.user.entities;

import fr.esipe.dataaccess.user.models.AccountDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author RubenEdery on 05/11/2017.
 */
@Data
@Entity(name = "history")
public class HistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private AccountEntity accountEntity;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "date_transaction")
	private Date datetransaction;
	
	
}
