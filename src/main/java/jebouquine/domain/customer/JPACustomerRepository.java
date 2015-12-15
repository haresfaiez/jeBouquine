package jebouquine.domain.customer;

import org.springframework.stereotype.Repository;

@Repository
public class JPACustomerRepository implements CustomerRepository {
    @Override
    public Customer getCurrentCustomer() {
        return Customer.nullObject();
    }
}
