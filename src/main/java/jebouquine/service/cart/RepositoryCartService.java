package jebouquine.service.cart;

import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryCartService implements CartService {

    private final Cart cart;
    private final BookRepository bookRepository;

    @Autowired
    public RepositoryCartService(Cart cart,
                                 BookRepository bookRepository) {
        this.cart = cart;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBookToCart(String bookISBN) {
        cart.addBook(bookRepository.findBookByISBN(bookISBN).get());
    }
}
