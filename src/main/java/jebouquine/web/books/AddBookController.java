package jebouquine.web.books;


import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AddBookController {

    private BookService service;

    @Autowired
    public AddBookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(value = "/book/add", method = GET)
    public final String askForAddBook(Model model) {
        model.addAttribute("book", AddBookViewModel.nullObject());
        model.addAttribute("booksearch", SearchBookViewModel.nullObject());
        return "book/add";
    }

    @RequestMapping(value = "/book/add", method = POST)
    public final String addBook(@ModelAttribute(value="book") AddBookViewModel
                                            addBookViewModel) {
        service.addBook(addBookViewModel);
        return "redirect:/";
    }
}
