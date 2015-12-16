package jebouquine.service.cart;

import jebouquine.domain.cart.Cart;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRequest;
import jebouquine.service.cart.viewmodel.OrderViewModel;

public class RepositoryOrderService implements OrderService {

    private Order order;

    private final OrderRequest orderRequest;
    private final Cart cart;

    public RepositoryOrderService(OrderRequest orderRequest, Cart cart) {
        this.cart = cart;
        this.orderRequest = orderRequest;
    }

    public static OrderService from(OrderRequest orderRequest, Cart cart) {
        return new RepositoryOrderService(orderRequest, cart);
    }

    @Override
    public OrderService pass() {
        order = cart.passOrderRequest(orderRequest);
        cart.removeAllPurchases();
        return this;
    }

    @Override
    public OrderViewModel viewModel() {
        return OrderViewModel.from(order);
    }
}
