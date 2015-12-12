package jebouquine.web.books;


import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/book/add")
public class AddBookController {

    private BookService service;

    @Autowired
    public AddBookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(method = GET)
    public final String askForAddBook() {
        return "book/add";
    }

    @RequestMapping(method = POST)
    public final String addBook(AddBookViewModel viewModel) {
        service.addBook(viewModel);
        return "home";
    }
}