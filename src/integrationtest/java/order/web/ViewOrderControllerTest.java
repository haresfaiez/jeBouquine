package order.web;

import factory.IntegrationTestOrderFactory;
import jebouquine.service.order.viewmodel.OrderViewModel;
import jebouquine.service.order.OrderService;
import jebouquine.web.context.SpringWebContext;
import jebouquine.web.order.ViewOrderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class ViewOrderControllerTest {

    @Test
    public void shouldReturnAnOrderWhenAskedForExistingOder() throws Exception {
        Integer orderId = 1;
        OrderViewModel expectedOrderViewModel =
                IntegrationTestOrderFactory.createOrderViewModel(orderId);

        OrderService orderService = mock(OrderService.class);
        when(orderService.getOrderById(orderId)).thenReturn
                (expectedOrderViewModel);
        ViewOrderController viewOrderController
                = new ViewOrderController(orderService);

        standaloneSetup(viewOrderController).build()
                .perform(get(String.format("/order/view/%s", orderId.toString())))
                .andExpect(view().name("order/view"))
                .andExpect(model().attribute("order", expectedOrderViewModel));
    }
}
