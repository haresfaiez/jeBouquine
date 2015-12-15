package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerCart implements Cart {

    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public CustomerCart(CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void addBook(Book book) {
        purchaseRepository.addPurchase(Purchase.now(book,
                customerRepository.getCurrentCustomer()));
    }

    @Override
    public List<Purchase> purchases() {
        return purchaseRepository.findPurchasesFor(
                customerRepository.getCurrentCustomer());
    }
}
