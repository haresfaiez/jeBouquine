package cart.domain;

import factory.MicroTestBookFactory;
import factory.MicroTestCustomerFactory;
import factory.MicroTestOrderFactory;
import factory.MicroTestPurchaseFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.cart.CustomerCart;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.customer.CustomerRepository;
import jebouquine.domain.order.CustomerOrderFactory;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderFactory;
import jebouquine.domain.order.OrderRequest;
import matcher.IsSamePurchase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class CustomerCartTest {

    @Test
    public void shouldPassOrder() {
        Book book = MicroTestBookFactory.createBook();
        Customer customer = MicroTestCustomerFactory.createCustomer();
        Purchase expectedPurchase = Purchase.now(book, customer);

        OrderFactory orderFactory = new CustomerOrderFactory();
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);
        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);
        List<Purchase> expectedPurchasesList = Stream.of(expectedPurchase).collect(Collectors.toList());
        when(purchaseRepository.findPurchasesFor(customer)).
                thenReturn(expectedPurchasesList);

        OrderRequest orderRequest = mock(OrderRequest.class);

        Cart customerCart = new CustomerCart(customerRepository,
                purchaseRepository,
                orderFactory);

        Order expectedOrder = MicroTestOrderFactory
                .createOrder(orderRequest, customer, expectedPurchasesList);

        Order actualOrder = customerCart.passOrderRequest(orderRequest);

        Assert.assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void shouldRemovePurchaseFromCart() {
        Book book = MicroTestBookFactory.createBook();
        Purchase expectedPurchase = mock(Purchase.class);

        OrderFactory orderFactory = mock(OrderFactory.class);
        Customer customer = MicroTestCustomerFactory.createCustomer();
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);

        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);
        when(purchaseRepository.findPurchase(customer, book)).
                thenReturn(expectedPurchase);

        Cart customerCart = new CustomerCart(customerRepository,
                purchaseRepository, orderFactory);

        customerCart.removeBook(book);

        verify(purchaseRepository, times(1))
                .removePurchase(expectedPurchase);
    }

    @Test
    public void shouldReturnPurchasesListOfTheCurrentCustomer() {
        Book expectedBook = MicroTestBookFactory.createBook();

        OrderFactory orderFactory = mock(OrderFactory.class);
        List<Purchase> expectedPurchaseList
                = Stream
                .of(MicroTestPurchaseFactory.createPurchaseFor(expectedBook))
                .collect(Collectors.toList());

        Customer customer = mock(Customer.class);
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);
        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);
        when(purchaseRepository.findPurchasesFor(customer))
                .thenReturn(expectedPurchaseList);

        Cart cart = new CustomerCart(customerRepository,
                purchaseRepository, orderFactory);

        List<Purchase> actualPurchaseList
                = cart.purchases();
        Assert.assertEquals(expectedPurchaseList, actualPurchaseList);

    }

    @Test
    public void shouldAddCustomerBookToHisCart() {
        Book book = MicroTestBookFactory.createBook();
        Customer customer = MicroTestCustomerFactory.createCustomer();
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);
        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);

        OrderFactory orderFactory = mock(OrderFactory.class);
        Cart customerCart = new CustomerCart(customerRepository,
                purchaseRepository, orderFactory);

        customerCart.addBook(book);

        verify(purchaseRepository, times(1))
                .addPurchase((Purchase)
                        argThat(IsSamePurchase.as(customer, book)));
    }

}
