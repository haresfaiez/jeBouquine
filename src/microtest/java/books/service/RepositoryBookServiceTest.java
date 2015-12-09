package books.service;

import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.service.books.BookService;
import jebouquine.service.books.RepositoryBookService;
import jebouquine.service.books.viewmodel.DetailsBookViewModel;
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
        final DetailsBookViewModel expectedDetailsBookViewModel = new DetailsBookViewModel(ISBN,
                                                        title);
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findBookByISBN(ISBN)).thenReturn(Optional.of
                (expectedBook));
        final BookService bookService = new RepositoryBookService
                (bookRepository);

        DetailsBookViewModel actualDetailsBookViewModel =
                bookService.searchForBookByISBN(ISBN);

        Assert.assertEquals(expectedDetailsBookViewModel, actualDetailsBookViewModel);
    }

    @Test
    public void shouldReturnANullBookViewModelWhenAskForANonExistingBookByISBN
            () {
        //TODO:wait for implementing the integration test
    }

}
