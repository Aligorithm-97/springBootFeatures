package springfeatures.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfeatures.spring.entity.models.Customer;
import springfeatures.spring.service.CustomerService;
import springfeatures.spring.service.CustomerServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/get")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customerparam) {
        customerService.addCustomer(customerparam);
        return "ok";
    }

    @GetMapping("/getbyid/{cid}")
    public Optional<Customer> getCustomerbyId(@PathVariable Long cid) {
        return customerService.getCustomerbyId(cid);
    }

    @GetMapping("/getbyidparam")
    public Optional<Customer> getCustomerbyIdparam(@RequestParam Long cid) {
        return customerService.getCustomerbyIdparam(cid);
    }
}
