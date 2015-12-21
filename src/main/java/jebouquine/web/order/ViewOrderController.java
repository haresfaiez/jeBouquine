package jebouquine.web.order;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewOrderController {

    private final OrderService orderService;

    @Autowired
    public ViewOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order/view/{id}", method = RequestMethod.GET)
    public String viewOrder(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        return "order/view";
    }

}
