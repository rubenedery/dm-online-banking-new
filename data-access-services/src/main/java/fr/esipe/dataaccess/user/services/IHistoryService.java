package fr.esipe.dataaccess.user.services;

import fr.esipe.dataaccess.user.models.AccountDto;
import fr.esipe.dataaccess.user.models.HistoryDto;

/**
 * @author RubenEdery on 05/11/2017.
 */
public interface IHistoryService {
	
	void create(HistoryDto historyDto);
}
