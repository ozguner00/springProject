package veresiye.example.veresiye.bussiness.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veresiye.example.veresiye.bussiness.abstracts.CustomerService;
import veresiye.example.veresiye.bussiness.mapper.ModelMapperService;
import veresiye.example.veresiye.bussiness.requests.CreateCustomerRequest;
import veresiye.example.veresiye.bussiness.responses.GetAllCustomerResponse;
import veresiye.example.veresiye.dataAccess.CustomerRepository;
import veresiye.example.veresiye.entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCustomerResponse> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> getAllCustomerResponses = customers.stream()
                .map(c -> modelMapperService.forRespoense()
                        .map(c,GetAllCustomerResponse.class)).collect(Collectors.toList());

        return getAllCustomerResponses;
    }

    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest,Customer.class);

        customerRepository.save(customer);

    }
}
