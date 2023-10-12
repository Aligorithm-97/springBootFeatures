package springfeatures.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springfeatures.spring.entity.models.Customer;
import springfeatures.spring.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerbyId(Long id){
        return customerRepository.findById(id);
    }
    @Override
    public Optional<Customer> getCustomerbyIdparam(Long id){
        return customerRepository.findById(id);
    }
}