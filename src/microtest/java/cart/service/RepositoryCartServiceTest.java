package cart.service;

import factory.MicroTestBookFactory;
import factory.MicroTestPurchaseFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.cart.Purchase;
import jebouquine.service.cart.CartService;
import jebouquine.service.cart.RepositoryCartService;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static factory.MicroTestPurchaseFactory.createPurchaseViewModelFor;
import static org.mockito.Mockito.*;

public class RepositoryCartServiceTest {

    @Test
    public void shouldRemovePurchaseFromCart() {
        Book expectedBook = MicroTestBookFactory.createBook();
        
        Cart cart = mock(Cart.class);
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findBookByISBN(expectedBook.getISBN()))
                .thenReturn(Optional.of(expectedBook));

        CartService cartService = new RepositoryCartService(cart,
                bookRepository);

        cartService.removeBookFromCart(expectedBook.getISBN());

        verify(cart, times(1)).removeBook(expectedBook);
    }

    @Test
    public void shouldCalculatePurchasesSum() {
        Book expectedBook = MicroTestBookFactory.createBook();
        BookRepository bookRepository = mock(BookRepository.class);

        List<Purchase> expectedPurchaseList
                = Stream
                .of(MicroTestPurchaseFactory.createPurchaseFor(expectedBook))
                .collect(Collectors.toList());


        Cart cart = mock(Cart.class);
        when(cart.purchases())
                .thenReturn(expectedPurchaseList);
        CartService cartService = new RepositoryCartService(cart,
                bookRepository);

        Integer actualSum = cartService.purchasesSum();

        Assert.assertEquals(new Integer(500), actualSum);
    }

    @Test
    public void shouldReturnPurchasesListOfTheCurrentCustomer() {
        Book expectedBook = MicroTestBookFactory.createBook();
        BookRepository bookRepository = mock(BookRepository.class);

        List<Purchase> expectedPurchaseList
                = Stream
                .of(MicroTestPurchaseFactory.createPurchaseFor(expectedBook))
                .collect(Collectors.toList());

        List<PurchaseViewModel> expectedPurchaseListViewModel
                = Stream
                .of(createPurchaseViewModelFor(expectedBook))
                .collect(Collectors.toList());

        Cart cart = mock(Cart.class);
        when(cart.purchases())
                .thenReturn(expectedPurchaseList);

        CartService cartService = new RepositoryCartService(cart,
                bookRepository);

        List<PurchaseViewModel> actualPurchaseListViewModel
                = cartService.purchases();
        Assert.assertEquals(expectedPurchaseListViewModel, actualPurchaseListViewModel);

    }

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
