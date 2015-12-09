package jebouquine.service.books;

import jebouquine.service.books.viewmodel.BookViewModel;

public interface BookService {
    BookViewModel searchForBookByISBN(String ISBN);
}
