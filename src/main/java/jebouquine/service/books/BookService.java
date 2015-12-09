package jebouquine.service.books;

import jebouquine.service.books.viewmodel.DetailsBookViewModel;

public interface BookService {
    DetailsBookViewModel searchForBookByISBN(String ISBN);
}
