package cart.web;

import jebouquine.service.cart.CartService;
import jebouquine.web.cart.AddBookToCartController;
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
public class AddBookToCartControllerTest {

    @Test
    public void shouldAddBookToCartWhenGivenExistingBook() throws Exception {
        final String bookISBN = "ABTCCT1";
        CartService cartService = mock(CartService.class);

        AddBookToCartController addBookToCartController =
                new AddBookToCartController(cartService);

        standaloneSetup(addBookToCartController).build()
                .perform(get(String.format("/cart/add-book/%s", bookISBN))
                        .param("ISBN", bookISBN));

        verify(cartService, times(1)).addBookToCart(bookISBN);
    }

}
