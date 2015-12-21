package jebouquine.service.order;

import jebouquine.domain.cart.Cart;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.domain.order.customerorder.OrderRequest;
import jebouquine.service.order.viewmodel.OrderViewModel;

public class CustomerOrderPassingService implements OrderPassingService {

    private Order order;

    private final OrderRequest orderRequest;
    private final Cart cart;
    private final OrderRepository orderRepository;

    public CustomerOrderPassingService(OrderRequest orderRequest, Cart cart, OrderRepository orderRepository) {
        this.cart = cart;
        this.orderRequest = orderRequest;
        this.orderRepository = orderRepository;
    }

    public static OrderPassingService from(OrderRequest orderRequest, Cart cart,
                                           OrderRepository orderRepository) {
        return new CustomerOrderPassingService(orderRequest, cart, orderRepository);
    }

    @Override
    public OrderPassingService pass() {
        order = cart.passOrderRequest(orderRequest);
        cart.removeAllPurchases();
        orderRepository.addOrder(order);
        return this;
    }

    @Override
    public OrderViewModel viewModel() {
        return OrderViewModel.from(order);
    }
}
