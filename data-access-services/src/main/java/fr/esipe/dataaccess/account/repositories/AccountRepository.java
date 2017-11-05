package fr.esipe.dataaccess.account.repositories;

import fr.esipe.dataaccess.account.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 03/11/2017.
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
	List<AccountEntity> findAll();
}
