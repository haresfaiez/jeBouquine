package factory;

import jebouquine.domain.cart.Order;

import static org.mockito.Mockito.mock;

public class IntegrationTestOrderFactory {
    public static Order createOrder() {
        return mock(Order.class);
    }

}
