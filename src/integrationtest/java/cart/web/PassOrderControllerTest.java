package cart.web;

import jebouquine.service.cart.CartService;
import jebouquine.web.cart.PassOrderController;
import jebouquine.web.context.SpringWebContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void shouldPassOrder(){

    }
}
