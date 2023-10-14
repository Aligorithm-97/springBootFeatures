package springfeatures.spring.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springfeatures.spring.entity.models.Customer;
import springfeatures.spring.repository.CustomerRepository;

import java.util.Calendar;
import java.util.Date;
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
    public Optional<Customer> getCustomerbyId(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerbyIdparam(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void changeCustomerVisibilityStatus() {
        Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date cutoffDate = calendar.getTime();
        customerRepository.updateStatusForOlderRecords(cutoffDate);

    }
}
//For getting a customer from database by id and after setting some fields save it to database

//        Optional<Customer> customerOptional = customerRepository.findById(cid);
//        if (customerOptional.isPresent()) {
//            Customer customer = customerOptional.get();
//            customer.setVisibilityStatus(Boolean.FALSE);
//            return customerRepository.save(customer);
//        } else {
//            throw new EntityNotFoundException("Customer not found with ID: " + cid);
//        }