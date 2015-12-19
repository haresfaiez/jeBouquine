package factory;

import jebouquine.domain.order.Order;
import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.order.viewmodel.OrderViewModel;

import static org.mockito.Mockito.mock;

public class IntegrationTestOrderFactory {
    public static Order createOrder() {
        return mock(Order.class);
    }

    public static OrderViewModel createOrderViewModel(Integer orderId) {
        return OrderViewModel.from(orderId, OrderPassingViewModel.nullObject());
    }
}
