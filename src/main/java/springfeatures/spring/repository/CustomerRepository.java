package springfeatures.spring.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springfeatures.spring.entity.models.Customer;

import java.util.Date;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Modifying
    @Transactional
    @Query("update Customer c set c.visibilityStatus=false where c.createdAt<:cutoffDate and c.visibilityStatus=true")
    void updateStatusForOlderRecords(@Param("cutoffDate") Date cutoffDate);
}
