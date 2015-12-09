package bookshelf;

import bookshelf.infrastructure.SpringApplicationTestContext;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import jebouquine.domain.bookshelf.Book;
import jebouquine.infrastructure.bookshelf.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = {SpringApplicationTestContext.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class JPABookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DatabaseSetup("/persistence/jpaBookRepositoryTest-init.xml")
    @ExpectedDatabase("/persistence/jpaBookRepositoryTest-expected.xml")
    public void shouldRetrieveExistingBookByISBN() {
        final String ISBN = "AAAA";
        final String title = "Hello spring";

        Book expectedBook = new Book(ISBN, title);
        Optional<Book> actualBook = bookRepository.findBookByISBN(ISBN);

        Assert.assertTrue(actualBook.isPresent());
        Assert.assertEquals(expectedBook, actualBook.get());
    }
}
