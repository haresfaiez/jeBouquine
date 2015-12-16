package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.customerorder.OrderRequest;

import java.util.List;

public interface Cart {
    void addBook(Book expectedBook);
    List<Purchase> purchases();
    void removeBook(Book expectedBook);
    Order passOrderRequest(OrderRequest order);
    void removeAllPurchases();
}
