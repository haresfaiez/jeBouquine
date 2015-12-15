package jebouquine.web.cart;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.service.cart.CartService;
import jebouquine.service.cart.viewmodel.CartViewModel;
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

    @RequestMapping(value = "/cart/view", method = RequestMethod.GET)
    public String viewPurchases(Model model) {
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        model.addAttribute("purchases", CartViewModel
                .from(cartService.purchases(), cartService.purchasesSum()));
        return "cart/view";
    }

}
