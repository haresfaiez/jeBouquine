package books.service;

import books.BookFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.infrastructure.books.JPABookRepository;
import jebouquine.service.books.BookService;
import jebouquine.service.books.RepositoryBookService;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class RepositoryBookServiceTest {

    @Test
    public void shouldReturnABookViewModelListWhenAskForAnExistingBookByTitle
            () {
        Book expectedBook = BookFactory.createBook();
        final BookViewModel expectedBookViewModel = BookViewModel.from(expectedBook);
        final SearchBookViewModel searchBookViewModel
                = SearchBookViewModel.fromTitle(BookFactory.bookTitle);
       BookRepository bookRepository = mock(BookRepository.class);
        final List<BookViewModel> expectedBooksList = Stream.of(expectedBookViewModel)
                .collect(Collectors.toList());
        when(bookRepository.findBooksByTitle(BookFactory.bookTitle)).thenReturn(
                Stream.of(expectedBook)
                        .collect(Collectors.toList())
        );
        final BookService bookService = new RepositoryBookService
                (bookRepository);

        List<BookViewModel> actualBooksList =
                bookService.searchForBooksByTitle(searchBookViewModel);

        Assert.assertEquals(expectedBooksList, actualBooksList);
    }

    @Test
    public void shouldAddBookToTheCatalogWhenGivenValidBookDetails() {
        AddBookViewModel actualAddBookViewModel = BookFactory.createAddBookViewModel();
        BookRepository jpaBookRepository = mock(JPABookRepository.class);
        Book expectedBook = actualAddBookViewModel.book();

        BookService repositoryBookService = new RepositoryBookService
                (jpaBookRepository);
        repositoryBookService.addBook(actualAddBookViewModel);
        verify(jpaBookRepository, times(1)).addBook(expectedBook);
    }

    @Test
    public void shouldReturnABookViewModelWhenAskedForAnExistingBookByISBN() {
        final Book expectedBook = BookFactory.createBook();
        final SearchBookViewModel searchBookViewModel
                = SearchBookViewModel.fromISBN(BookFactory.bookISBN);
        final BookViewModel expectedBookViewModel = BookViewModel.from
                (expectedBook);
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findBookByISBN(BookFactory.bookISBN)).thenReturn(Optional.of
                (expectedBook));
        final BookService bookService = new RepositoryBookService
                (bookRepository);

        BookViewModel actualBookViewModel =
                bookService.searchForBookByISBN(searchBookViewModel);

        Assert.assertEquals(expectedBookViewModel, actualBookViewModel);
    }

    @Test
    public void shouldReturnANullBookViewModelWhenAskForANonExistingBookByISBN
            () {
        //TODO:wait for implementing the integration test
    }

}
