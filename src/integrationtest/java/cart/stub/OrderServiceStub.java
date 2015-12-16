package cart.stub;

import factory.IntegrationTestOrderFactory;
import jebouquine.domain.cart.Order;
import jebouquine.service.cart.OrderService;
import jebouquine.service.cart.viewmodel.OrderPassingViewModel;
import jebouquine.service.cart.viewmodel.OrderViewModel;

public class OrderServiceStub implements OrderService {

    private Integer id;
    private OrderPassingViewModel orderPassingViewModel;
    public OrderServiceStub(Integer id, OrderPassingViewModel
                            orderPassingViewModel) {
        this.orderPassingViewModel = orderPassingViewModel;
        this.id = id;
    }

    @Override
    public OrderService pass() {
        return this;
    }

    @Override
    public Order order() {
        return IntegrationTestOrderFactory.createOrder();
    }

    @Override
    public OrderViewModel viewModel() {
        return OrderViewModel.from(id,orderPassingViewModel);
    }

    public static OrderService newInstance(Integer id, OrderPassingViewModel
                                                   orderPassingViewModel) {
        return new OrderServiceStub(id, orderPassingViewModel);
    }
}
