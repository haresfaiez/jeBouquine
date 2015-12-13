package books.service;

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

import java.util.Optional;

import static org.mockito.Mockito.*;

public class RepositoryBookServiceTest {

    @Test
    public void shouldAddBookToTheCatalogWhenGivenValidBookDetails() {
        final String bookISBN = "AAAA";
        final String bookTitle = "Spring is awesome";
        Book expectedBook = new Book(bookISBN, bookTitle);
        AddBookViewModel actualAddBookViewModel = new AddBookViewModel
                (bookISBN, bookTitle);
        BookRepository jpaBookRepository = mock(JPABookRepository.class);

        BookService repositoryBookService = new RepositoryBookService
                (jpaBookRepository);
        repositoryBookService.addBook(actualAddBookViewModel);
        verify(jpaBookRepository, times(1)).addBook(expectedBook);
    }

    @Test
    public void shouldReturnABookViewModelWhenAskForAnExistingBookByISBN() {

        final String ISBN = "AAAA";
        final String title = "Hello Spring";
        final Book expectedBook = new Book(ISBN, title);
        final SearchBookViewModel searchBookViewModel
                = new SearchBookViewModel(
                            SearchBookViewModel.getCriteriaISBN(),
                            ISBN);
        final BookViewModel expectedBookViewModel = new BookViewModel(ISBN,
                title);
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findBookByISBN(ISBN)).thenReturn(Optional.of
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
