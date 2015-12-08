package jebouquine.service.bookshelf;

import jebouquine.service.bookshelf.viewmodel.BookViewModel;
import org.springframework.stereotype.Service;

@Service
public class RepositoryBookService implements BookService {
    @Override
    public BookViewModel searchForBookByISBN(String ISBN) {
        return null;
    }
}
