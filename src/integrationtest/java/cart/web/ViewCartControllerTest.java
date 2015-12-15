package cart.web;

import factory.IntegrationTestPurchaseFactory;
import jebouquine.service.cart.CartService;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;
import jebouquine.web.cart.ViewCartController;
import jebouquine.web.context.SpringWebContext;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class ViewCartControllerTest {

    @Test
    public void shouldListPurchaseWhenAskedToViewCart() throws Exception {
        List<PurchaseViewModel> expectedPurchaseListViewModel =
                Stream.of(
                        IntegrationTestPurchaseFactory.createRandomPurchaseViewModel(),
                        IntegrationTestPurchaseFactory.createRandomPurchaseViewModel()
                ).collect(Collectors.toList());

        CartService cartService = mock(CartService.class);
        when(cartService.purchases()).thenReturn(expectedPurchaseListViewModel);

        ViewCartController viewCartController = new ViewCartController
                (cartService);

        standaloneSetup(viewCartController).build()
                .perform(get("/cart/view"))
                .andExpect(view().name("cart/view"))
                .andExpect(model().attribute("purchases",
                        expectedPurchaseListViewModel));
    }

}
