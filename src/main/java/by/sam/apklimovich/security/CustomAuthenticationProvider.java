package by.sam.apklimovich.security;

import by.sam.apklimovich.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
        logger.info("!!!A U T H E N T I C A T I O N !!! ");
        logger.info(authentication.toString());
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        loginService.isFirstStart();
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (loginService.checkCredentials(name, password)) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<>());
        } else {
            return authentication;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}