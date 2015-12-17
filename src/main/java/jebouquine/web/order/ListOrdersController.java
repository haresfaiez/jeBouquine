package jebouquine.web.order;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.service.order.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListOrdersController {

    private final OrdersService ordersService;

    @Autowired
    public ListOrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public String listCustomerOrders(Model model) {
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        model.addAttribute("orders", ordersService.getCurrentCustomerOrders());
        return "order/list";
    }
}
