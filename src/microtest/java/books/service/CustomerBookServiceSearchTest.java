package books.service;

import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.service.books.BookService;
import jebouquine.service.books.CustomerBookService;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerBookServiceSearchTest {

    private Book expectedBook;
    private BookViewModel expectedBookViewModel;
    private List<BookViewModel> expectedBooksList;

    @Test
    public void shouldReturnMatchedBooksWhenAskedForSearchingBookByTitle() {
        BookService bookService
                = new CustomerBookService(createBookRepositoryStub());
        SearchBookViewModel searchBookViewModel
                = SearchBookViewModel.fromTitle(expectedBook.getTitle());

        List<BookViewModel> actualBooksList =
                bookService.searchForBooksByTitle(searchBookViewModel);

        Assert.assertEquals(expectedBooksList, actualBooksList);
    }

    @Test
    public void shouldReturnBookWhenAskedForSearchingAnExistingBookByISBN() {
        BookService bookService = new CustomerBookService
                (createBookRepositoryStub());
        SearchBookViewModel searchBookViewModel
                = SearchBookViewModel.fromISBN(expectedBook.getISBN());

        BookViewModel actualBookViewModel =
                bookService.searchForBookByISBN(searchBookViewModel);

        Assert.assertEquals(expectedBookViewModel, actualBookViewModel);
    }

    @Before
    public void setUp() {
        expectedBook = Book.nullObject();
        expectedBookViewModel = BookViewModel.from(expectedBook);
        expectedBooksList
                = Stream.of(expectedBookViewModel)
                .collect(Collectors.toList());
    }

    public BookRepository createBookRepositoryStub() {
        BookRepository bookRepository = mock(BookRepository.class);

        when(bookRepository
                .findBooksByTitle(expectedBook.getTitle()))
                .thenReturn(Stream.of(expectedBook).collect(Collectors.toList()));

        when(bookRepository.findBookByISBN(expectedBook.getISBN()))
                .thenReturn(Optional.of(expectedBook));
        return bookRepository;
    }
}
