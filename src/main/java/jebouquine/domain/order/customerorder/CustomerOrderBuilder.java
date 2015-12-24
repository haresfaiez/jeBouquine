package jebouquine.domain.order.customerorder;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderBuilder;

public class CustomerOrderBuilder implements OrderBuilder {

    private final CustomerOrder order;

    public CustomerOrderBuilder() {
        order = CustomerOrder.nullObject();
    }

    @Override
    public CustomerOrderBuilder withPurchase(Purchase purchase) {
        order.addItem(OrderItem.from(purchase));
        return this;
    }

    @Override
    public CustomerOrderBuilder forCustomer(Customer customer) {
        order.setCustomer(customer);
        return this;
    }

    @Override
    public Order get() {
        return order;
    }

    @Override
    public CustomerOrderBuilder fromRequest(OrderRequest orderRequest) {
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerPhone(orderRequest.getCustomerPhone());
        order.setExpeditionDate(orderRequest.getExpeditionDate());
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        order.setDeliveryAddress(orderRequest.getDeliveryAddress());
        return this;
    }

    public static OrderBuilder newInstance() {
        return new CustomerOrderBuilder();
    }
}
