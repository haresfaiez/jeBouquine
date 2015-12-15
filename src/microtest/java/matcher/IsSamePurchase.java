package matcher;

import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import org.hamcrest.Matcher;
import org.mockito.ArgumentMatcher;

public class IsSamePurchase extends ArgumentMatcher {

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

    public static Matcher<Object> as(Customer customer, Book book) {
        return new IsSamePurchase(customer, book);
    }
}
