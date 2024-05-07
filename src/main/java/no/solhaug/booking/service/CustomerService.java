package no.solhaug.booking.service;

import lombok.RequiredArgsConstructor;
import no.solhaug.booking.beans.Customer;
import no.solhaug.booking.jpaRepos.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Transactional
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Transactional

    public boolean customerExists(Long id){
        return customerRepository.existsById(id);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

}
