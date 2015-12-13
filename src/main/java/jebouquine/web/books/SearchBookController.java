package jebouquine.web.books;

import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchBookController {
    private BookService service;

    @Autowired
    public SearchBookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(value = "/book/search")
    public final String findBookByISBN(@ModelAttribute(value = "booksearch") SearchBookViewModel viewModel
            , Model model) {
        //TODO:remove those "if"s open closed principle
        if (viewModel.isSearchByISBN()) {
            BookViewModel book = service.searchForBookByISBN(viewModel);
            model.addAttribute("book", book.getISBN());
            return "redirect:/book/view/{book}";
        }
        if (viewModel.isSearchByTitle())  {
            List<BookViewModel> books = service.searchForBooksByTitle(viewModel);
            model.addAttribute("books", books);
            return "book/search/result";
        }
        throw new IllegalArgumentException(
                "Search criteria argument not supported");
    }
}
