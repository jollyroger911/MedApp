package by.sam.apklimovich.config;

import by.sam.apklimovich.security.RefererAuthenticationSuccessHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@ImportResource({ "classpath:RedirectionWebSecurityConfig.xml" })
//@EnableWebSecurity
//@Profile("!https")
public class RedirectionSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("pass")
                .roles("USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/login_form*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.successHandler(new SavedRequestAwareAuthenticationSuccessHandler());
                .successHandler(new RefererAuthenticationSuccessHandler());
    }

}