package jebouquine.service.order;

import jebouquine.service.cart.viewmodel.OrderViewModel;
import org.springframework.stereotype.Service;

@Service
public class RepositoryOrdersService implements OrdersService {
    @Override
    public OrderViewModel getOrderById(Integer orderId) {
        return null;
    }
}
