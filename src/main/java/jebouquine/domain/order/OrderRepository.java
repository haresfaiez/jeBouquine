package jebouquine.domain.order;

import java.util.Optional;

public interface OrderRepository {
    void addOrder(Order expectedOrder);
    Optional<Order> findOrderById(Integer id);
}
