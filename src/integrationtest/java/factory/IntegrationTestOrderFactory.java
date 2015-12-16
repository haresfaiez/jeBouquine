package factory;

import jebouquine.domain.order.Order;

import static org.mockito.Mockito.mock;

public class IntegrationTestOrderFactory {
    public static Order createOrder() {
        return mock(Order.class);
    }

}
