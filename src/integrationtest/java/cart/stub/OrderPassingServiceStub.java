package cart.stub;

import jebouquine.service.order.OrderPassingService;
import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.order.viewmodel.OrderViewModel;

public class OrderPassingServiceStub implements OrderPassingService {

    private Integer id;
    private OrderPassingViewModel orderPassingViewModel;
    public OrderPassingServiceStub(Integer id, OrderPassingViewModel
                            orderPassingViewModel) {
        this.orderPassingViewModel = orderPassingViewModel;
        this.id = id;
    }

    @Override
    public OrderPassingService pass() {
        return this;
    }

    @Override
    public OrderViewModel viewModel() {
        return OrderViewModel.from(id,orderPassingViewModel);
    }

    public static OrderPassingService newInstance(Integer id, OrderPassingViewModel
                                                   orderPassingViewModel) {
        return new OrderPassingServiceStub(id, orderPassingViewModel);
    }
}
