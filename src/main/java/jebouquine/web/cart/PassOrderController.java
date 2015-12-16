package jebouquine.web.cart;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PassOrderController {

    private final CartService cartService;

    @Autowired
    public PassOrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart/pass-order", method = RequestMethod.GET)
    public String getOrderPassingFro(Model model) {
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        return "cart/order/pass";
    }

}
