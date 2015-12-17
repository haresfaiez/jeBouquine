package jebouquine.domain.order;

import jebouquine.domain.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void addOrder(Order expectedOrder);
    Optional<Order> findOrderById(Integer id);
    List<Order> findOrdersFor(Customer customer);
}
