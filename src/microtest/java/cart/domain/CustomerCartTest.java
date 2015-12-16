package cart.domain;

import factory.MicroTestBookFactory;
import factory.MicroTestCustomerFactory;
import factory.MicroTestPurchaseFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.*;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.customer.CustomerRepository;
import matcher.IsForSame;
import matcher.IsSamePurchase;
import mock.OrderFactoryMock;
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

        OrderFactoryMock orderFactory = new OrderFactoryMock();
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.getCurrentCustomer()).thenReturn(customer);
        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);
        when(purchaseRepository.findPurchasesFor(customer)).
                thenReturn(Stream.of(expectedPurchase).collect(Collectors.toList()));

        OrderRequest orderRequest = mock(OrderRequest.class);

        Cart customerCart = new CustomerCart(customerRepository,
                purchaseRepository,
                orderFactory);

        customerCart.passOrder(orderRequest);

        verify(purchaseRepository, times(1))
                .removePurchase((Purchase)
                        argThat(IsForSame.customer(customer)));
        Assert.assertEquals(new Integer(1),
                orderFactory.getBuildOrderCallsNumber());
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
