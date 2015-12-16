package jebouquine.service.order;

import jebouquine.domain.order.OrderRepository;
import jebouquine.service.cart.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryOrdersService implements OrdersService {

    private final OrderRepository orderRepository;

    @Autowired
    public RepositoryOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderViewModel getOrderById(Integer orderId) {
        return OrderViewModel.from(orderRepository.findOrderById(orderId).get());
    }
}
