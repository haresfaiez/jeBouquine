package jebouquine.domain.order.customerorder;

import jebouquine.domain.order.OrderBuilder;
import jebouquine.domain.order.OrderFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderFactory implements OrderFactory {
    @Override
    public OrderBuilder buildOrder() {
        return CustomerOrderBuilder.newInstance();
    }
}
