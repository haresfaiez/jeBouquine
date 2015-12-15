package factory;

import jebouquine.domain.customer.Customer;

public class MicroTestCustomerFactory {
    public static Customer createCustomer() {
        return Customer.nullObject();
    }
}
