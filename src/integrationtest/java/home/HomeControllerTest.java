package home;

import jebouquine.web.context.SpringWebContext;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebContext.class})
@WebAppConfiguration
public class HomeControllerTest {

    public static final String HOME_PAGE_MAPPING = "/";
    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void shouldProvideSearchByISBNOnHomePage() throws Exception {
        MockMvc mockMvc;
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        mockMvc.perform(get(HOME_PAGE_MAPPING))
                .andExpect(view().name(HOME_VIEW_NAME));
    }

}
