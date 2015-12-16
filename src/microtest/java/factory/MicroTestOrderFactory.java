package factory;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.CustomerOrder;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderItem;
import jebouquine.domain.order.OrderRequest;

import java.util.List;
import java.util.stream.Collectors;

public class MicroTestOrderFactory {
    public static Order createOrder
            (OrderRequest orderRequest, Customer customer, List<Purchase> purchasesList) {
        return new CustomerOrder(0, orderRequest.getCustomerName(),
                orderRequest.getCustomerPhone(), orderRequest
                .getExpeditionDate(),
                orderRequest.getPaymentMethod(),
                orderRequest.getDeliveryAddress(),
                customer,
                itemsForPurchases(purchasesList));
    }

    private static List<OrderItem> itemsForPurchases(List<Purchase> purchasesList) {
        return purchasesList
                .stream()
                .map(purchase -> OrderItem.from(purchase))
                .collect(Collectors.toList());
    }
}
