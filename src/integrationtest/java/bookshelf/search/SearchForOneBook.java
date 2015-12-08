package bookshelf.search;

import jebouquine.service.bookshelf.BookService;
import jebouquine.service.bookshelf.viewmodel.BookViewModel;
import jebouquine.web.SpringWebContext;
import jebouquine.web.bookshelf.BookSearchController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class SearchForOneBook {

    //TODO:externalize constants below
    public static final String HOME_PAGE_MAPPING = "/";
    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void shouldProvideSearchByISBNOnHomePage() throws Exception {
        this.mockMvc.perform(get(HOME_PAGE_MAPPING))
                .andExpect(view().name(HOME_VIEW_NAME));
    }

    @Test
    public void shouldReturnBookViewWhenSearchForAnExistingBookByISBN()
            throws Exception {
        final String ISBN = "AAAA";
        final String title = "Hello Spring";
        final BookViewModel expectedBookViewModel =  new BookViewModel(ISBN,
                                                                        title);
        BookService bookService = mock(BookService.class);
        given(bookService.searchForBookByISBN(ISBN)).willReturn
                (expectedBookViewModel);

        BookSearchController bookSearchController = new
                BookSearchController(bookService);
        standaloneSetup(bookSearchController).build()
                .perform(post("/search").param("ISBN", ISBN))
                .andExpect(model()
                        .attribute("book", expectedBookViewModel))
                .andExpect(view().name("book"));
    }
}
