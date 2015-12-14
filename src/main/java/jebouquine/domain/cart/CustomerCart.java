package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerCart implements Cart {

    private final Customer customer;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public CustomerCart(Customer customer, PurchaseRepository purchaseRepository) {
        this.customer = customer;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void addBook(Book book) {
        purchaseRepository.addPurchase(customer, book);
    }
}
