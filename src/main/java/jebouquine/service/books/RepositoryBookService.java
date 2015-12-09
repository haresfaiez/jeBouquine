package jebouquine.service.books;

import jebouquine.infrastructure.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.service.books.viewmodel.DetailsBookViewModel;
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
    public DetailsBookViewModel searchForBookByISBN(String ISBN) {
        return DetailsBookViewModel.from(
                bookRepository
                        .findBookByISBN(ISBN)
                        .orElse(Book.nullObject()));
    }
}
