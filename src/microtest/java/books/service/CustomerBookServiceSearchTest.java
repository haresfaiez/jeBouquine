package books.service;

import books.stub.InMemoryBookRepository;
import jebouquine.domain.books.Book;
import jebouquine.service.books.BookService;
import jebouquine.service.books.CustomerBookService;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jebouquine.service.books.viewmodel.BookViewModel.from;
import static jebouquine.service.books.viewmodel.SearchBookViewModel.byISBN;
import static jebouquine.service.books.viewmodel.SearchBookViewModel.byTitle;

public class CustomerBookServiceSearchTest {

    InMemoryBookRepository bookRepository = InMemoryBookRepository.create();
    BookService bookService;

    @Test
    public void shouldReturnMatchedBooksWhenAskedForSearchingBookByTitle() {
        Book expectedBook = bookRepository.getAnExistingBook();
        List<BookViewModel> expectedBooksList
                = bookViewModelsOf(expectedBook);
        SearchBookViewModel searchBookViewModel
                = byTitle(expectedBook.getTitle());

        List<BookViewModel> actualBooksList =
                bookService.searchForBooksByTitle(searchBookViewModel);

        Assert.assertEquals(expectedBooksList, actualBooksList);
    }

    @Test
    public void shouldReturnBookWhenAskedForSearchingAnExistingBookByISBN() {
        Book expectedBook = bookRepository.getAnExistingBook();
        SearchBookViewModel searchBookViewModel
                = byISBN(expectedBook.getISBN());
        BookViewModel expectedBookViewModel = from(expectedBook);

        BookViewModel actualBookViewModel =
                bookService.searchForBookByISBN(searchBookViewModel);

        Assert.assertEquals(expectedBookViewModel, actualBookViewModel);
    }

    @Before
    public void setUp() {
        bookService = new CustomerBookService(bookRepository);
    }

    private static List<BookViewModel> bookViewModelsOf(Book book) {
        return Stream.of(BookViewModel.from(book))
                .collect(Collectors.toList());
    }


}
