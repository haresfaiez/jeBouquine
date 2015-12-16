package jebouquine.infrastructure.order;

import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JPAOrderRepository implements OrderRepository {
    @Override
    public void addOrder(Order expectedOrder) {

    }
}
