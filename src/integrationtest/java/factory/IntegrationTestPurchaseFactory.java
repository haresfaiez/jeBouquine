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
        final Integer bookPrice = 100;
        return PurchaseViewModel.from(bookISBN, bookTitle, DATE, bookPrice);
    }
    public static Purchase createPurchaseFrom(Integer id, Customer customer,
                                              Book
            book) {
        return Purchase.from(id, book, customer, new Date(12, 29, 2014));
    }
}
