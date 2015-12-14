package jebouquine.web.context;

import jebouquine.SpringApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String APPLICATION_ROOT = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { SpringApplicationContext.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { SpringWebContext.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {APPLICATION_ROOT};
    }
}
