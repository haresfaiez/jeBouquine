package cart.web;

import jebouquine.service.cart.CartService;
import jebouquine.web.cart.ManageCartController;
import jebouquine.web.context.SpringWebContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request
        .MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class ManageCartControllerTest {

    @Test
    public void shouldRemovePurchaseFromTheCart() throws Exception {
        final String bookISBN = "ABTCCT1";
        CartService cartService = mock(CartService.class);

        ManageCartController manageCartController =
                new ManageCartController(cartService);

        standaloneSetup(manageCartController).build()
                .perform(get(String.format("/cart/remove-book/%s", bookISBN))
                        .param("ISBN", bookISBN));

        verify(cartService, times(1)).removeBookFromCart(bookISBN);

    }
}
