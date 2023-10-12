package springfeatures.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springfeatures.spring.entity.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
