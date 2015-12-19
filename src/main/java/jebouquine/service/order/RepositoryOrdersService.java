package jebouquine.service.order;

import jebouquine.domain.customer.CustomerRepository;
import jebouquine.domain.order.OrderRepository;
import jebouquine.service.order.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryOrdersService implements OrdersService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public RepositoryOrdersService(OrderRepository orderRepository,
                                   CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderViewModel getOrderById(Integer orderId) {
        return OrderViewModel.from(orderRepository.findOrderById(orderId).get());
    }

    @Override
    public List<OrderViewModel> getCurrentCustomerOrders() {
        return orderRepository
                .findOrdersFor(customerRepository.getCurrentCustomer())
                .stream()
                .map(order -> OrderViewModel.from(order))
                .collect(Collectors.toList());
    }
}
