package jebouquine.domain.cart;

import jebouquine.domain.customer.Customer;

import java.util.List;

public interface PurchaseRepository {
    void addPurchase(Purchase purchase);
    List<Purchase> findPurchasesFor(Customer customer);
    void removePurchase(Purchase purchase);
}
