package order.service;

import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.domain.order.customerorder.CustomerOrder;
import jebouquine.service.cart.viewmodel.OrderViewModel;
import jebouquine.service.order.RepositoryOrdersService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RepositoryOrdersServiceTest {

    @Test
    public void shouldFindOrderById() {

        Order expectedOrder = CustomerOrder.nullObject();
        final Integer orderId = expectedOrder.getId();
        OrderViewModel expectedOrderViewModel = OrderViewModel.from(expectedOrder);

        OrderRepository orderRepository = mock(OrderRepository.class);
        when(orderRepository.findOrderById(orderId)).thenReturn
                (Optional.of(expectedOrder));

        RepositoryOrdersService
                repositoryOrdersService = new RepositoryOrdersService
                (orderRepository);

        OrderViewModel actualOrderViewModel = repositoryOrdersService
                .getOrderById(orderId);

        Assert.assertEquals(expectedOrderViewModel,
                actualOrderViewModel);
    }
}
