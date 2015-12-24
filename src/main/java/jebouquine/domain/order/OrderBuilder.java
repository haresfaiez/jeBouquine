package jebouquine.domain.order;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.customerorder.OrderRequest;

public interface OrderBuilder {
    OrderBuilder withPurchase(Purchase purchase);
    OrderBuilder forCustomer(Customer currentCustomer);
    Order get();
    OrderBuilder fromRequest(OrderRequest orderRequest);
}
