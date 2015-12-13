package jebouquine.service.books;

import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;

import java.util.List;

public interface BookService {
    BookViewModel searchForBookByISBN(SearchBookViewModel searchBookViewModel);
    void addBook(AddBookViewModel addBookViewModel);
    List<BookViewModel> searchForBooksByTitle(SearchBookViewModel searchBookViewModel);
}
