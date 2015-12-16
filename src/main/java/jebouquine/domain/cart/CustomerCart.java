package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.customer.CustomerRepository;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderBuilder;
import jebouquine.domain.order.OrderFactory;
import jebouquine.domain.order.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerCart implements Cart {

    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;
    private final OrderFactory orderFactory;

    @Autowired
    public CustomerCart(CustomerRepository customerRepository,
                        PurchaseRepository purchaseRepository,
                        OrderFactory orderFactory) {
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
        this.orderFactory = orderFactory;
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

    @Override
    public void removeBook(Book book) {
        purchaseRepository.removePurchase(purchaseRepository
                .findPurchase(customerRepository.getCurrentCustomer(), book));
    }

    @Override
    public Order passOrder(OrderRequest orderRequest) {
        OrderBuilder orderBuilder = orderFactory.buildOrder();
        purchases()
                .stream()
                .forEach(purchase -> orderBuilder.withPurchase(purchase));
        orderBuilder.fromRequest(orderRequest);
        orderBuilder.forCustomer(customerRepository.getCurrentCustomer());
        removeAllPurchases();
        return orderBuilder.get();

    }

    public void removeAllPurchases() {
        purchases()
                .stream()
                .forEach(purchase -> purchaseRepository.removePurchase(purchase));
    }
}
