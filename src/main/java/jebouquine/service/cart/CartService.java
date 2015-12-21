package jebouquine.service.cart;

import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;
import jebouquine.service.order.OrderPassingService;

import java.util.List;

public interface CartService {
    void addBookToCart(String bookISBN);
    List<PurchaseViewModel> purchases();
    Integer purchasesSum();
    void removeBookFromCart(String bookISBN);
    OrderPassingService orderServiceOf(OrderPassingViewModel orderPassingViewModel);
}
