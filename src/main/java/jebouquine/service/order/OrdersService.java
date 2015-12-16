package jebouquine.service.order;

import jebouquine.service.cart.viewmodel.OrderViewModel;

public interface OrdersService {
    OrderViewModel getOrderById(Integer orderId);
}
