package bookshelf.search;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookShelfApplicationContext.class})
@WebAppConfiguration
public class SearchForOneBook {

    //TODO:externalize constants below
    public static final String HOME_PAGE_MAPPING = "/home";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void shouldProvideSearchByISBN() throws Exception {
        this.mockMvc.perform(get(HOME_PAGE_MAPPING))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindABookByISBN() {
        //TODO:mock the service[use BookShelfApplicationContext]
        //TODO:send and check a get http request
    }
}
