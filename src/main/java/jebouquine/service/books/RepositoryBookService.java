package jebouquine.service.books;

import jebouquine.domain.books.Book;
import jebouquine.infrastructure.books.BookRepository;
import jebouquine.service.books.viewmodel.BookViewModel;
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
