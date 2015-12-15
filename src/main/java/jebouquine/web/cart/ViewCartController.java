package jebouquine.web.cart;

import jebouquine.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewCartController {

    private final CartService cartService;

    @Autowired
    public ViewCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(name = "", method = RequestMethod.GET)
    public String viewPurchases(Model model) {
        model.addAttribute("purchases", cartService.purchases());
        return "cart/view";
    }

}
