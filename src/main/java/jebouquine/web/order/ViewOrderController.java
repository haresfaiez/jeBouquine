package jebouquine.web.order;

import jebouquine.service.order.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewOrderController {

    private final OrdersService ordersService;

    @Autowired
    public ViewOrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "/order/view/{id}", method = RequestMethod.GET)
    public String viewOrder(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", ordersService.getOrderById(id));
        return "order/view";
    }

}
