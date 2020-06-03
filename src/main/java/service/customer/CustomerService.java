package service.customer;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import respository.customer.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Customer model) {
        customerRepository.saveOrUpdate(model);
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
