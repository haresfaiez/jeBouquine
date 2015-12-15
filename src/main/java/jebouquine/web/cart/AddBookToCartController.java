package jebouquine.web.cart;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddBookToCartController {

    private final CartService cartService;

    @Autowired
    public AddBookToCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart/add-book/{ISBN}", method = RequestMethod.GET)
    public String addBookToCart(@PathVariable("ISBN") String ISBN, Model model){
        cartService.addBookToCart(ISBN);
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        return "redirect:/cart/view";
    }

}
