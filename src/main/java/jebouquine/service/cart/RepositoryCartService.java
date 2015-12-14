package jebouquine.service.cart;

import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryCartService implements CartService {

    private final CartRepository cartRepository;
    private final BookRepository bookRepository;

    @Autowired
    public RepositoryCartService(CartRepository cartRepository,
                                 BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBookToCart(String bookISBN) {
        cartRepository.addBookToCart(bookRepository.findBookByISBN(bookISBN).get());
    }
}
