package jebouquine.domain.customer;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    public static Customer nullObject() {
        return new Customer();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Customer;
    }
}
