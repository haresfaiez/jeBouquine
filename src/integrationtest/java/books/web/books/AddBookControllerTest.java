package books.web.books;

import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.web.SpringWebContext;
import jebouquine.web.books.AddBookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class AddBookControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void shouldAllowALogisticManagerToAddNewBook() throws Exception {
        BookService bookService = mock(BookService.class);

        AddBookController addBookController = new
                AddBookController(bookService);
        standaloneSetup(addBookController).build()
                .perform(get("/book/add"))
                .andExpect(view().name("book/add"));
    }

    @Test
    public void shouldAddNewBookWhenGivenValidBookDetails() throws Exception {
        AddBookViewModel expectedAddBookViewModel = BookFactory
                .createAddBookViewModel();
        BookService bookService = mock(BookService.class);
        AddBookController addBookController = new
                AddBookController(bookService);
        standaloneSetup(addBookController).build()
                .perform(post("/book/add")
                        .param("ISBN", BookFactory.bookISBN)
                        .param("title", BookFactory.bookTitle)
                        .param("price", String.valueOf(BookFactory.bookPrice.get()))
                        .param("summary", BookFactory.bookSummary)
                        .param("author", BookFactory.bookAuthor));
        verify(bookService, times(1)).addBook(expectedAddBookViewModel);
    }
}
