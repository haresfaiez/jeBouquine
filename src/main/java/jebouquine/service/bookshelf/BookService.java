package jebouquine.service.bookshelf;

import jebouquine.service.bookshelf.viewmodel.BookViewModel;

public interface BookService {
    BookViewModel searchForBookByISBN(String ISBN);
}
