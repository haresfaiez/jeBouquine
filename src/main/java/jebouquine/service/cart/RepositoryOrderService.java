package jebouquine.service.cart;

import jebouquine.domain.cart.Cart;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.domain.order.OrderRequest;
import jebouquine.service.cart.viewmodel.OrderViewModel;

public class RepositoryOrderService implements OrderService {

    private Order order;

    private final OrderRequest orderRequest;
    private final Cart cart;
    private final OrderRepository orderRepository;

    public RepositoryOrderService(OrderRequest orderRequest, Cart cart, OrderRepository orderRepository) {
        this.cart = cart;
        this.orderRequest = orderRequest;
        this.orderRepository = orderRepository;
    }

    public static OrderService from(OrderRequest orderRequest, Cart cart,
                                    OrderRepository orderRepository) {
        return new RepositoryOrderService(orderRequest, cart, orderRepository);
    }

    @Override
    public OrderService pass() {
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
