package jebouquine.domain.order;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.customerorder.OrderRequest;

public interface OrderBuilder {
    void withPurchase(Purchase purchase);
    void forCustomer(Customer currentCustomer);
    Order get();
    void fromRequest(OrderRequest orderRequest);
}
