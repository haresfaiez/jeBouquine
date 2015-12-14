package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.customer.Customer;

public interface PurchaseRepository {
    void addPurchase(Customer customer, Book book);
}
