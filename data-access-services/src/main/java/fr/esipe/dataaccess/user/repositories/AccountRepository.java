package fr.esipe.dataaccess.user.repositories;

import fr.esipe.dataaccess.user.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 03/11/2017.
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
	List<AccountEntity> findAll();
}
