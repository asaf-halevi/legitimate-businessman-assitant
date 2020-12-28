package repo;

import model.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Integer> {

    Optional<Business> findByName(String name);
}
