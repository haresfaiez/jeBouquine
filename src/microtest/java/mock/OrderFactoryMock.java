package mock;

import jebouquine.domain.order.OrderBuilder;
import jebouquine.domain.order.OrderFactory;

import static org.mockito.Mockito.mock;

public class OrderFactoryMock implements OrderFactory {

    private Integer buildOrderCallsNumber = new Integer(0);
    @Override
    public OrderBuilder buildOrder() {
        buildOrderCallsNumber = buildOrderCallsNumber.intValue() + 1;
        return mock(OrderBuilder.class);
    }

    public Integer getBuildOrderCallsNumber() {
        return buildOrderCallsNumber;
    }
}
