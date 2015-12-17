package jebouquine.web.order;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.service.cart.CartService;
import jebouquine.service.cart.viewmodel.OrderPassingViewModel;
import jebouquine.service.cart.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String getOrderPassingFrom(Model model) {
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        model.addAttribute("order", OrderPassingViewModel.nullObject());
        return "cart/order/pass";
    }

    @RequestMapping(value = "/cart/pass-order", method = RequestMethod.POST)
    public String passOrder(@ModelAttribute(value = "order")
                            OrderPassingViewModel orderPassingViewModel) {
        OrderViewModel orderViewModel
                = cartService
                .orderServiceOf(orderPassingViewModel)
                .pass()
                .viewModel();
//        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
//        model.addAttribute("order", orderViewModel);
        //TODO:fix redirection string construction
//        model.addAttribute("orderId", "1");
//        return "redirect:/cart/order/view/{orderId}";
        return String.format("redirect:/order/view/%s",
                orderViewModel.getId());
    }

}
