package jebouquine.service.cart;

import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;
import jebouquine.service.order.OrderService;

import java.util.List;

public interface CartService {
    void addBookToCart(String bookISBN);
    List<PurchaseViewModel> purchases();
    Integer purchasesSum();
    void removeBookFromCart(String bookISBN);
    OrderService orderServiceOf(OrderPassingViewModel orderPassingViewModel);
}
