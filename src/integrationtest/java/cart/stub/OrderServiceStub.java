package cart.stub;

import jebouquine.service.order.OrderService;
import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.order.viewmodel.OrderViewModel;

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
    public OrderViewModel viewModel() {
        return OrderViewModel.from(id,orderPassingViewModel);
    }

    public static OrderService newInstance(Integer id, OrderPassingViewModel
                                                   orderPassingViewModel) {
        return new OrderServiceStub(id, orderPassingViewModel);
    }
}
