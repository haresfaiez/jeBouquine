package cart.service;

import factory.MicroTestBookFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.CartRepository;
import jebouquine.service.cart.CartService;
import jebouquine.service.cart.RepositoryCartService;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class RepositoryCartServiceTest {

    @Test
    public void shouldAddABookToTheCatalogWhenGivenAValidBookISBN() {
        Book expectedBook = MicroTestBookFactory.createBook();

        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findBookByISBN(expectedBook.getISBN()))
                .thenReturn(Optional.of(expectedBook));

        CartRepository cartRepository = mock(CartRepository.class);

        CartService repositoryCartService = new
                RepositoryCartService(cartRepository, bookRepository);

        repositoryCartService.addBookToCart(expectedBook.getISBN());

        verify(cartRepository, times(1)).addBookToCart(expectedBook);
    }
}
