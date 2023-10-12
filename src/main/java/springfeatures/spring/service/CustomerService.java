package springfeatures.spring.service;

import springfeatures.spring.entity.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getCustomers();
    void addCustomer(Customer customer);
    Optional<Customer> getCustomerbyId(Long id);
    Optional<Customer> getCustomerbyIdparam(Long id);
}
