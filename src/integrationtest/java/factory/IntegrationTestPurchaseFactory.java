package factory;

import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;

import java.util.Date;

public class IntegrationTestPurchaseFactory {
    private final static Date DATE = new Date();
    public static PurchaseViewModel createRandomPurchaseViewModel() {
        final String bookISBN = String.format("ISBN %s", Math.random());
        final String bookTitle = String.format("title %s", Math.random());
        return PurchaseViewModel.from(bookISBN, bookTitle, DATE);
    }
    public static Purchase createPurchaseFrom(Customer customer, Book book) {
        return Purchase.now(book, customer);
    }
}
