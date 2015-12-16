package cart.web;

import cart.stub.OrderServiceStub;
import jebouquine.service.cart.CartService;
import jebouquine.service.cart.viewmodel.OrderPassingViewModel;
import jebouquine.service.cart.viewmodel.OrderViewModel;
import jebouquine.web.cart.PassOrderController;
import jebouquine.web.context.SpringWebContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class PassOrderControllerTest {

    @Test
    public void shouldGiveOrderPassingForm() throws Exception {
        CartService cartService = mock(CartService.class);
        PassOrderController passOrderController = new
                PassOrderController(cartService);

        standaloneSetup(passOrderController).build()
                .perform(get("/cart/pass-order"))
                .andExpect(view().name("cart/order/pass"));
    }

    @Test
    public void shouldPassOrder() throws Exception {
        CartService cartService = mock(CartService.class);
        PassOrderController passOrderController = new
                PassOrderController(cartService);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH, 5);
        Date expirationDate = cal.getTime();

        OrderPassingViewModel actualOrderPassingViewModel
                = OrderPassingViewModel
                .from("Faiez", "26871788", expirationDate, "manual", "Tunis");
        OrderViewModel expectedOrderViewModel = OrderViewModel
                .from(1, actualOrderPassingViewModel);

        when(cartService.orderServiceOf(actualOrderPassingViewModel))
                .thenReturn(OrderServiceStub.newInstance
                        (1, actualOrderPassingViewModel));

        standaloneSetup(passOrderController).build()
                .perform(post("/cart/pass-order")
                        .param("customerName", actualOrderPassingViewModel
                                .getCustomerName())
                        .param("customerPhone", actualOrderPassingViewModel.getCustomerPhone())
                        .param("expeditionDate", "08/05/2016")
                        .param("paymentMethod", actualOrderPassingViewModel.getPaymentMethod())
                        .param("deliveryAddress", actualOrderPassingViewModel.getDeliveryAddress())
                )
                .andExpect(model().attribute("order", expectedOrderViewModel))
                .andExpect(view().name(String.format
                        ("redirect:/cart/order/view/%s",
                        expectedOrderViewModel.getId())));
    }
}
