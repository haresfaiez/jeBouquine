package jebouquine.domain.cart;

import jebouquine.domain.customer.Customer;

public interface OrderBuilder {
    void withPurchase(Purchase purchase);

    void forCustomer(Customer currentCustomer);

    Order get();

    void fromRequest(OrderRequest orderRequest);
}
