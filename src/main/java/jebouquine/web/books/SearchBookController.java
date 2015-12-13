package jebouquine.web.books;

import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.DetailsBookViewModel;
import jebouquine.service.books.viewmodel.SearchBookFormViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/book/search")
public class SearchBookController {
    private BookService service;

    @Autowired
    public SearchBookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(method = GET)
    public final String findBookByISBN(@ModelAttribute(value="booksearch") SearchBookFormViewModel viewModel
            , Model model) {
        DetailsBookViewModel book = service.searchForBookByISBN(viewModel.getISBN());
        model.addAttribute("book", book.getISBN());
        return "redirect:book/view/{book}";
    }
}
