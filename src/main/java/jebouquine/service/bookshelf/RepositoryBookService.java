package jebouquine.service.bookshelf;

import bookshelf.domain.Book;
import jebouquine.infrastructure.bookshelf.BookRepository;
import jebouquine.service.bookshelf.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryBookService implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public RepositoryBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookViewModel searchForBookByISBN(String ISBN) {
        return BookViewModel.from(
                bookRepository
                        .findBookByISBN(ISBN)
                        .orElse(Book.nullObject()));
    }
}
