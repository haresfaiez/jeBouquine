package jebouquine.service.cart;

import jebouquine.domain.cart.Order;
import jebouquine.service.cart.viewmodel.OrderViewModel;

public interface OrderService {
    OrderService pass();
    Order order();
    OrderViewModel viewModel();
}
