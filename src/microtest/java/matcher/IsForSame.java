package matcher;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import org.hamcrest.Matcher;
import org.mockito.ArgumentMatcher;

public class IsForSame extends ArgumentMatcher {
        private Customer customer;

    public IsForSame(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean matches(Object argument) {
        Purchase purchase = (Purchase) argument;
        return  purchase.getCustomer().equals(customer);
    }

    public static Matcher<Object> customer(Customer customer) {
        return new IsForSame(customer);
    }
}
