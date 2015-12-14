package jebouquine.web.cart;

import jebouquine.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AddBookToCartController {

    private final CartService cartService;

    @Autowired
    public AddBookToCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart/add-book/{ISBN}", method = RequestMethod.GET)
    public String addBookToCart(@PathVariable("ISBN") String ISBN, Model model){
        cartService.addBookToCart(ISBN);
        model.addAttribute("book", ISBN);
        return "redirect:/book/view/{book}";
    }

}
