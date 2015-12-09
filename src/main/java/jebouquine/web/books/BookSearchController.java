package jebouquine.web.books;


import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.BookSearchBookViewModel;
import jebouquine.service.books.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/search")
public class BookSearchController {

    private BookService service;

    @Autowired
    public BookSearchController(BookService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public final String searchByISBN(BookSearchBookViewModel viewModel
                                                        , Model model) {
        BookViewModel book = service.searchForBookByISBN(viewModel.getISBN());
        model.addAttribute("book", book);
        return "book";
    }

}
