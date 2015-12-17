package jebouquine.service.order;

import jebouquine.service.cart.viewmodel.OrderViewModel;

import java.util.List;

public interface OrdersService {
    OrderViewModel getOrderById(Integer orderId);
    List<OrderViewModel> getCurrentCustomerOrders();
}
