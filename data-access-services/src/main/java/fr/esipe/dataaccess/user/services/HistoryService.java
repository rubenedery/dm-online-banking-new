package fr.esipe.dataaccess.user.services;

import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.entities.HistoryEntity;
import fr.esipe.dataaccess.user.models.AccountDto;
import fr.esipe.dataaccess.user.models.HistoryDto;
import fr.esipe.dataaccess.user.repositories.HistoryRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author RubenEdery on 05/11/2017.
 */
public class HistoryService implements IHistoryService {
	
	
	private final HistoryRepository historyRepository;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	
	@Autowired
	public HistoryService(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}
	
	@Override
	public void create(HistoryDto historyDto) {
		
		HistoryEntity historyEntity = mapper.map(historyDto,HistoryEntity.class);
		historyEntity.setAccountEntity(mapper.map(historyDto.getAccountDto(),AccountEntity.class));
		historyRepository.save(historyEntity);
	}
	
	

}
