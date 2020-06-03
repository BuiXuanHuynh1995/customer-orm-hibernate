package respository.customer;

import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public List findAll() {
        TypedQuery<Customer> query =em.createQuery("select c from Customer c",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.id=:id",Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void saveOrUpdate(Customer model) {
        if (model.getId()!=null){
            em.merge(model);
        }else
            em.persist(model);
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        if (customer!=null){
            em.remove(customer);
        }
    }
}
