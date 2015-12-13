package jebouquine.web.books;

import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.SearchBookFormViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewBookController {

    final private BookService bookService;

    @Autowired
    public ViewBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book/view/{ISBN}", method = RequestMethod.GET)
    public String viewBookDetails(@PathVariable("ISBN") String ISBN,
                                  Model model) {
        model.addAttribute("booksearch", SearchBookFormViewModel.nullObject());
        model.addAttribute("bookDetails", bookService.searchForBookByISBN
                (ISBN));
        return "book/view";
    }

}
