package jebouquine.service.order;

import jebouquine.service.order.viewmodel.OrderViewModel;

import java.util.List;

public interface OrderService {
    OrderViewModel getOrderById(Integer orderId);
    List<OrderViewModel> getCurrentCustomerOrders();
}
