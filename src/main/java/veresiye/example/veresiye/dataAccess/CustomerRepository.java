package veresiye.example.veresiye.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import veresiye.example.veresiye.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
