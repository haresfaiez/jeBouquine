package books.web.books;

import jebouquine.service.books.BookService;
import jebouquine.service.books.viewmodel.BookViewModel;
import jebouquine.service.books.viewmodel.SearchBookViewModel;
import jebouquine.web.SpringWebContext;
import jebouquine.web.books.SearchBookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class SearchBookControllerTest {

    //TODO:externalize constants below
    public static final String HOME_PAGE_MAPPING = "/";
    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void shouldReturnMatchedBookListWhenSearchForAnExistingBookByTitle()
            throws Exception {
        final String ISBN = "AAAA";
        final String title = "Hello Spring";
        final BookViewModel expectedBookViewModel = new BookViewModel(ISBN,
                title);
        List<BookViewModel> expectedResult = Stream.of(expectedBookViewModel).collect(Collectors.toList());

        BookService bookService = mock(BookService.class);
        given(bookService.searchForBooksByTitle(SearchBookViewModel.fromTitle
                (title))).willReturn
                (expectedResult);

        SearchBookController searchBookController = new
                SearchBookController(bookService);
        standaloneSetup(searchBookController).build()
                .perform(get("/book/search")
                        .param("criteria", SearchBookViewModel.getCriteriaTitle())
                        .param("value", title))
                .andExpect(model()
                        .attribute("books", expectedResult))
                .andExpect(view().name
                        ("redirect:/book/search/result/{book}"));
    }


    //TODO:Move this to an independent test "HomeControllerTest"
    @Test
    public void shouldProvideSearchByISBNOnHomePage() throws Exception {
        MockMvc mockMvc;
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        mockMvc.perform(get(HOME_PAGE_MAPPING))
                .andExpect(view().name(HOME_VIEW_NAME));
    }

    @Test
    public void shouldReturnBookViewWhenSearchForAnExistingBookByISBN()
            throws Exception {
        final String ISBN = "AAAA";
        final String title = "Hello Spring";
        final BookViewModel expectedBookViewModel = new BookViewModel(ISBN,
                title);
        BookService bookService = mock(BookService.class);
        given(bookService.searchForBookByISBN(SearchBookViewModel.fromISBN(ISBN)
        )).willReturn
                (expectedBookViewModel);

        SearchBookController searchBookController = new
                SearchBookController(bookService);
        standaloneSetup(searchBookController).build()
                .perform(get("/book/search")
                        .param("criteria", SearchBookViewModel.getCriteriaISBN())
                        .param("value", ISBN))
                .andExpect(model()
                        .attribute("book", ISBN))
                .andExpect(view().name
                        ("redirect:/book/view/{book}"));
    }
}
