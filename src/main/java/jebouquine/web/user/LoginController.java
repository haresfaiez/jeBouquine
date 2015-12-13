package jebouquine.web.user;

import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String logIn(Model model){
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        return "user/login";
    }
}
