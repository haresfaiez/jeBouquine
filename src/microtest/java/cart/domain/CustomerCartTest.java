package cart.domain;

import factory.MicroTestBookFactory;
import factory.MicroTestCustomerFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.cart.CustomerCart;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import static org.mockito.Mockito.*;

public class CustomerCartTest {

    @Test
    public void shouldAddCustomerBookToHisCart() {
        Book book = MicroTestBookFactory.createBook();
        Customer customer = MicroTestCustomerFactory.createCustomer();
        Purchase purchase = Purchase.now(book, customer);
        PurchaseRepository purchaseRepository = mock(PurchaseRepository.class);

        Cart customerCart = new CustomerCart(customer, purchaseRepository);

        customerCart.addBook(book);

        verify(purchaseRepository, times(1))
                .addPurchase((Purchase)
                        argThat(new IsSamePurchase(customer, book)));
    }

    class IsSamePurchase extends ArgumentMatcher {

        private Customer customer;
        private Book book;

        public IsSamePurchase(Customer customer, Book book) {
            this.customer = customer;
            this.book = book;
        }

        @Override
        public boolean matches(Object argument) {
            Purchase purchase = (Purchase) argument;
            return ((Purchase) argument).getBook().equals(book)
                    && purchase.getCustomer().equals(customer);
        }
    }
}
