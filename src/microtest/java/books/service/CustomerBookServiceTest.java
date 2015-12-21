package books.service;

import factory.MicroTestBookFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.infrastructure.books.JPABookRepository;
import jebouquine.service.books.BookService;
import jebouquine.service.books.CustomerBookService;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomerBookServiceTest {

    @Test
    public void shouldAddBookToTheCatalogWhenGivenANewBook() {
        AddBookViewModel actualAddBookViewModel
                = MicroTestBookFactory.createAddBookViewModel();
        Book expectedBook = actualAddBookViewModel.book();
        BookRepository jpaBookRepository = mock(JPABookRepository.class);
        BookService customerBookService
                = new CustomerBookService(jpaBookRepository);

        customerBookService.addBook(actualAddBookViewModel);

        verify(jpaBookRepository, times(1)).addBook(expectedBook);
    }

}
