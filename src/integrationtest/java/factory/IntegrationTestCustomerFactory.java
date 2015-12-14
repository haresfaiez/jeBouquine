package factory;

import jebouquine.domain.customer.Customer;

public class IntegrationTestCustomerFactory {
    public static Customer createCustomer() {
        return new Customer();
    }
}
