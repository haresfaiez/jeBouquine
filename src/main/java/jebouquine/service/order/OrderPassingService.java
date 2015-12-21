package jebouquine.service.order;

import jebouquine.service.order.viewmodel.OrderViewModel;

public interface OrderPassingService {
    OrderPassingService pass();
    OrderViewModel viewModel();
}
