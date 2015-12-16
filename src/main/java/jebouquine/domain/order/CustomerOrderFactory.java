package jebouquine.domain.order;

import org.springframework.stereotype.Component;

@Component
public class CustomerOrderFactory implements OrderFactory {
    @Override
    public OrderBuilder buildOrder() {
        return null;
    }
}
