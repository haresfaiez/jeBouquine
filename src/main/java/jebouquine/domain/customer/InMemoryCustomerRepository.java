package jebouquine.domain.customer;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Customer currentCustomer
            = new Customer("faiez_customer");

    @Override
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
}
