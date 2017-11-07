package fr.esipe.dataaccess.user.repositories;

import fr.esipe.dataaccess.user.entities.HistoryEntity;
import fr.esipe.dataaccess.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 05/11/2017.
 */
public interface HistoryRepository extends CrudRepository<HistoryEntity, Long> {
	List<HistoryEntity> findAll();
}
