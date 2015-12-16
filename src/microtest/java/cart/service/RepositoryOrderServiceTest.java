package cart.service;

import jebouquine.domain.cart.Cart;
import jebouquine.domain.order.OrderRequest;
import jebouquine.service.cart.RepositoryOrderService;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RepositoryOrderServiceTest {


    @Test
    public void shouldPassOrder() {
        Cart cart = mock(Cart.class);
        OrderRequest expectedOrderRequest = mock(OrderRequest.class);

        RepositoryOrderService orderService
                = new RepositoryOrderService(expectedOrderRequest, cart);

        orderService.pass();

        verify(cart, times(1)).passOrder(expectedOrderRequest);
    }
}
