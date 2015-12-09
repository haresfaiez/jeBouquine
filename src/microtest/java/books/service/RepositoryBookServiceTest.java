package books.service;

import jebouquine.domain.books.Book;
import jebouquine.infrastructure.books.BookRepository;
import jebouquine.service.books.BookService;
import jebouquine.service.books.RepositoryBookService;
import jebouquine.service.books.viewmodel.BookViewModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RepositoryBookServiceTest {

    @Test
    public void shouldReturnABookViewModelWhenAskForAnExistingBookByISBN() {

        final String ISBN = "AAAA";
        final String title = "Hello Spring";
        final Book expectedBook = new Book(ISBN, title);
        final BookViewModel expectedBookViewModel = new BookViewModel(ISBN,
                                                        title);
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findBookByISBN(ISBN)).thenReturn(Optional.of
                (expectedBook));
        final BookService bookService = new RepositoryBookService
                (bookRepository);

        BookViewModel actualBookViewModel = bookService.searchForBookByISBN
                (ISBN);

        Assert.assertEquals(expectedBookViewModel, actualBookViewModel);
    }

    @Test
    public void shouldReturnANullBookViewModelWhenAskForANonExistingBookByISBN
            () {
        //TODO:wait for implementing the integration test
    }

}
