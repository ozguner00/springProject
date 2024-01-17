package veresiye.example.veresiye.bussiness.abstracts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import veresiye.example.veresiye.bussiness.requests.CreateCustomerRequest;
import veresiye.example.veresiye.bussiness.responses.GetAllCustomerResponse;

import java.util.List;


public interface CustomerService {
    List<GetAllCustomerResponse> getAllCustomer();
    void add(CreateCustomerRequest createCustomerRequest);
}
