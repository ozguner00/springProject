package veresiye.example.veresiye.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veresiye.example.veresiye.bussiness.abstracts.CustomerService;
import veresiye.example.veresiye.bussiness.requests.CreateCustomerRequest;
import veresiye.example.veresiye.bussiness.responses.GetAllCustomerResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor

public class CustomerController {
    private CustomerService customerService;

    @GetMapping()
    public String getMessage(){
        return "Başarıyla program ayağa kalktı.";
    }
    @GetMapping("/all")
    public List<GetAllCustomerResponse> getAllCustomer(){
        List<GetAllCustomerResponse> customers = customerService.getAllCustomer();
        return customers;
    }

    @PostMapping("/add")
    public void createCustomerRequest(CreateCustomerRequest createCustomerRequest){
        this.customerService.add(createCustomerRequest);
        System.out.println("Başarıyla eklendi :" + createCustomerRequest.getName());
    }
}
