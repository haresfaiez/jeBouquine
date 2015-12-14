package cart.domain;

import factory.MicroTestBookFactory;
import factory.MicroTestCustomerFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.cart.CustomerCart;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomerCartTest {

    @Test
    public void shouldAddCustomerBookToHisCart() {
        Book book = MicroTestBookFactory.createBook();
        Customer customer = MicroTestCustomerFactory.createCustomer();
        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);

        Cart customerCart = new CustomerCart(customer, purchaseRepository);

        customerCart.addBook(book);

        verify(purchaseRepository, times(1)).addPurchase(customer, book);
    }
}
