package jebouquine.service.cart;

import jebouquine.service.cart.viewmodel.PurchaseViewModel;

import java.util.List;

public interface CartService {
    void addBookToCart(String bookISBN);
    List<PurchaseViewModel> purchases();
    Integer purchasesSum();
    void removeBookFromCart(String bookISBN);
}
