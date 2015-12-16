package books.web;

import factory.IntegrationTestBookFactory;
import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.web.context.SpringWebContext;
import jebouquine.web.books.ViewBookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class ViewBookControllerTest {

    @Test
    public void shouldGiveBookDetailsWhenAskedForAnExistingBookDetails() throws Exception {
        final BookViewModel expectedBookViewModel
                = IntegrationTestBookFactory.createBookViewModel();

        SearchBookViewModel searchBookViewModel
                = SearchBookViewModel.fromISBN(IntegrationTestBookFactory.bookISBN);
        BookService bookService = mock(BookService.class);
        when(bookService.searchForBookByISBN(searchBookViewModel)).thenReturn
                (expectedBookViewModel);

        ViewBookController viewBookController
                = new ViewBookController(bookService);

        standaloneSetup(viewBookController).build()
                .perform(get(String.format("/book/view/%s", IntegrationTestBookFactory.bookISBN)))
                .andExpect(view().name("book/view"))
                .andExpect(model().attribute("bookDetails", expectedBookViewModel));
    }

}
