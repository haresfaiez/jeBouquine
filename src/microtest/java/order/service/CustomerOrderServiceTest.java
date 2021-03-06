package order.service;

import jebouquine.domain.customer.Customer;
import jebouquine.domain.customer.CustomerRepository;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.domain.order.customerorder.CustomerOrder;
import jebouquine.service.order.viewmodel.OrderViewModel;
import jebouquine.service.order.OrderService;
import jebouquine.service.order.CustomerOrderService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerOrderServiceTest {

    @Test
    public void shouldListCurrentCustomerOrders() {
        Customer customer = Customer.nullObject();
        CustomerOrder firstOrder = CustomerOrder.nullObject();
        CustomerOrder secondOrder = CustomerOrder.nullObject();
        secondOrder.setId(1);
        firstOrder.setCustomer(customer);
        secondOrder.setCustomer(customer);

        CustomerRepository customerRepository
                = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);

        OrderViewModel firstOrderViewModel
                = OrderViewModel.from(firstOrder);
        OrderViewModel secondOrderViewModel
                = OrderViewModel.from(secondOrder);
        List<Order> expectedOrdersList
                = Stream.of(firstOrder, secondOrder).collect(Collectors.toList());

        List<OrderViewModel> expectedOrdersViewModelList
                = Stream.of(firstOrderViewModel, secondOrderViewModel)
                .collect(Collectors.toList());

        OrderRepository orderRepository = mock(OrderRepository.class);
        when(orderRepository.findOrdersFor(customer)).thenReturn(expectedOrdersList);
        OrderService orderService = new CustomerOrderService
                (orderRepository, customerRepository);

        List<OrderViewModel> actualOrdersViewModeList
                = orderService.getCurrentCustomerOrders();

        Assert.assertEquals(expectedOrdersViewModelList,
                actualOrdersViewModeList);
    }

    @Test
    public void shouldFindOrderById() {

        Customer customer = Customer.nullObject();
        CustomerRepository customerRepository
                = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);

        Order expectedOrder = CustomerOrder.nullObject();
        final Integer orderId = expectedOrder.getId();
        OrderViewModel expectedOrderViewModel = OrderViewModel.from(expectedOrder);

        OrderRepository orderRepository = mock(OrderRepository.class);
        when(orderRepository.findOrderById(orderId)).thenReturn
                (Optional.of(expectedOrder));

        CustomerOrderService
                repositoryOrdersService = new CustomerOrderService
                (orderRepository, customerRepository);

        OrderViewModel actualOrderViewModel = repositoryOrdersService
                .getOrderById(orderId);

        Assert.assertEquals(expectedOrderViewModel,
                actualOrderViewModel);
    }
}
