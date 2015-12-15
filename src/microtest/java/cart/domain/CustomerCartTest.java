package cart.domain;

import factory.MicroTestBookFactory;
import factory.MicroTestCustomerFactory;
import factory.MicroTestPurchaseFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.cart.CustomerCart;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.customer.CustomerRepository;
import matcher.IsSamePurchase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class CustomerCartTest {

    @Test
    public void shouldReturnPurchasesListOfTheCurrentCustomer() {
        Book expectedBook = MicroTestBookFactory.createBook();

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
                purchaseRepository);

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

        Cart customerCart = new CustomerCart(customerRepository, purchaseRepository);

        customerCart.addBook(book);

        verify(purchaseRepository, times(1))
                .addPurchase((Purchase)
                        argThat(IsSamePurchase.as(customer, book)));
    }

}
