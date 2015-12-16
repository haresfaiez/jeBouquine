package jebouquine.domain.order;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;

public interface OrderBuilder {
    void withPurchase(Purchase purchase);

    void forCustomer(Customer currentCustomer);

    Order get();

    void fromRequest(OrderRequest orderRequest);
}
