package bookshelf;

import bookshelf.infrastructure.SpringApplicationTestContext;
import jebouquine.infrastructure.bookshelf.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringApplicationTestContext.class})
public class JPABookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldRetrieveExistingBookByISBN() {
//        final String ISBN = "AAAA";
//        final String title = "Hello Spring";
//
//        Book expectedBook = new Book(ISBN, title);
//        Optional<Book> actualBook = bookRepository.findBookByISBN(ISBN);
//
//        Assert.assertTrue(actualBook.isPresent());
//        Assert.assertEquals(expectedBook, actualBook);
    }
}
