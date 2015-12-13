package jebouquine.service.books;

import jebouquine.domain.books.BookRepository;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepositoryBookService implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public RepositoryBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookViewModel searchForBookByISBN(SearchBookViewModel searchBookViewModel) {
        return BookViewModel.from(
                bookRepository
                        .findBookByISBN(searchBookViewModel.getISBN())
                        .get());
    }

    @Override
    public void addBook(AddBookViewModel addBookViewModel) {
        bookRepository.addBook(addBookViewModel.book());
    }

    @Override
    public List<BookViewModel> searchForBooksByTitle(SearchBookViewModel searchBookViewModel) {
        return
                bookRepository
                        .findBooksByTitle(searchBookViewModel.getTitle())
                        .stream()
                        .map(book -> BookViewModel.from(book))
                        .collect(Collectors.toList());
    }

}
