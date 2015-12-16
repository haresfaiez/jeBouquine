package cart.service;

import factory.MicroTestOrderFactory;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.domain.order.OrderRequest;
import jebouquine.service.cart.RepositoryOrderService;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class RepositoryOrderServiceTest {


    @Test
    public void shouldPassOrder() {
        Cart cart = mock(Cart.class);
        Customer customer = Customer.nullObject();
        OrderRequest expectedOrderRequest = OrderRequest.nullObject();
        Order expectedOrder = MicroTestOrderFactory
                .createOrder(expectedOrderRequest, customer, new ArrayList<>());
        OrderRepository orderRepository = mock(OrderRepository.class);

        when(cart.passOrderRequest(expectedOrderRequest)).thenReturn
                (expectedOrder);

        RepositoryOrderService orderService
                = new RepositoryOrderService(expectedOrderRequest, cart, orderRepository);


        orderService.pass();

        verify(cart, times(1)).passOrderRequest(expectedOrderRequest);
        verify(cart, times(1)).removeAllPurchases();
        verify(orderRepository, times(1)).addOrder(expectedOrder);
    }
}
