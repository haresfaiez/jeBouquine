package books.service;

import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.service.books.BookService;
import jebouquine.service.books.CustomerBookService;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import org.junit.Test;

import static jebouquine.service.books.viewmodel.AddBookViewModel.from;
import static org.mockito.Mockito.*;

public class CustomerBookServiceTest {

    @Test
    public void shouldAddBookToTheCatalogWhenGivenANewBook() {
        Book expectedBook = Book.nullObject();
        AddBookViewModel actualAddBookViewModel = from(expectedBook);
        BookRepository bookRepository = mock(BookRepository.class);
        BookService customerBookService
                = new CustomerBookService(bookRepository);

        customerBookService.addBook(actualAddBookViewModel);

        verify(bookRepository, times(1)).addBook(expectedBook);
    }

}
