package jebouquine;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin()
                    .loginPage("/login")
                .and()
                .authorizeRequests()
                    .antMatchers("/book/add")
                    .access("hasRole('LOGISTIC_MANAGER')")
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .logoutUrl("/logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER");
        auth.inMemoryAuthentication()
                .withUser("faiez_logistic")
                .password("0000")
                .roles("LOGISTIC_MANAGER");
        auth.inMemoryAuthentication()
                .withUser("faiez")
                .password("0000")
                .roles("ADMIN");
    }
}
