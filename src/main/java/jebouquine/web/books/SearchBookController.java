package jebouquine.web.books;


import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.SearchBookFormViewModel;
import jebouquine.service.books.viewmodel.DetailsBookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/search")
public class SearchBookController {

    private BookService service;

    @Autowired
    public SearchBookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public final String searchByISBN(SearchBookFormViewModel viewModel
                                                        , Model model) {
        DetailsBookViewModel book = service.searchForBookByISBN(viewModel.getISBN());
        model.addAttribute("book", book);
        return "book";
    }

}
