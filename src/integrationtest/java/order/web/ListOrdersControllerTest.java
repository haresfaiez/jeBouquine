package order.web;

import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.order.viewmodel.OrderViewModel;
import jebouquine.service.order.OrdersService;
import jebouquine.web.context.SpringWebContext;
import jebouquine.web.order.ListOrdersController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class ListOrdersControllerTest {

    @Test
    public void shouldListCustomerOrders() throws Exception {

        OrderViewModel firstOrderViewModel
                = OrderViewModel.nullObject();
        OrderViewModel secondOrderViewModel
                = OrderViewModel.from(1, OrderPassingViewModel.nullObject());

        List<OrderViewModel> expectedOrdersViewModelList
                = Stream.of(
                firstOrderViewModel,
                secondOrderViewModel
        ).collect(Collectors.toList());

        OrdersService ordersService = mock(OrdersService.class);
        when(ordersService.getCurrentCustomerOrders()).thenReturn
                (expectedOrdersViewModelList);

        ListOrdersController listOrdersController
                = new ListOrdersController(ordersService);

        standaloneSetup(listOrdersController).build()
                .perform(get("/order/list"))
                .andExpect(view().name("order/list"))
                .andExpect(model().attribute("orders", expectedOrdersViewModelList));
    }
}
