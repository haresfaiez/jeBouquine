package factory;

import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;

public class MicroTestPurchaseFactory {
    public static PurchaseViewModel createPurchaseViewModelFor(Book expectedBook) {
        return PurchaseViewModel.now(expectedBook.getISBN(), expectedBook
                .getTitle(), expectedBook.getPrice().get());
    }

    public static Purchase createPurchaseFor(Book book) {
        return Purchase.now(book, Customer.nullObject());
    }
}
