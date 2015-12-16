package jebouquine.domain.order;

import jebouquine.domain.customer.Customer;

import java.util.Date;
import java.util.List;

public interface Order {
    String getDeliveryAddress();

    Date getExpeditionDate();

    String getPaymentMethod();

    String getCustomerPhone();

    String getCustomerName();

    Integer getId();

    Customer getCustomer();

    List<OrderItem> getItems();

    void addItem(OrderItem item);
}
