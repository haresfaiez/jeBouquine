package cart.service;

import factory.MicroTestBookFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.Cart;
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

        Cart cart = mock(Cart.class);

        CartService repositoryCartService = new
                RepositoryCartService(cart, bookRepository);

        repositoryCartService.addBookToCart(expectedBook.getISBN());

        verify(cart, times(1)).addBook(expectedBook);
    }
}
