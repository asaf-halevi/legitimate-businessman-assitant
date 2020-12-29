package repo;

import entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    List<Payment> findByBusinessId(@Param("id") Integer businessId);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
