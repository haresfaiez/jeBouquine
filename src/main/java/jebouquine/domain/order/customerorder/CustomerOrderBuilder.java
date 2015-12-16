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
    public void withPurchase(Purchase purchase) {
        order.addItem(OrderItem.from(purchase));
    }

    @Override
    public void forCustomer(Customer customer) {
        order.setCustomer(customer);
    }

    @Override
    public Order get() {
        return order;
    }

    @Override
    public void fromRequest(OrderRequest orderRequest) {
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerPhone(orderRequest.getCustomerPhone());
        order.setExpeditionDate(orderRequest.getExpeditionDate());
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        order.setDeliveryAddress(orderRequest.getDeliveryAddress());
    }

    public static OrderBuilder newInstance() {
        return new CustomerOrderBuilder();
    }
}
