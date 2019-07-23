package org.holab.librarian.web.security;

import lombok.extern.slf4j.Slf4j;
import org.holab.librarian.web.dto.UserDto;
import org.holab.librarian.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String userPw = authentication.getCredentials().toString();
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private Authentication authenticate(String id, String pw) throws AuthenticationException {
        Optional<UserDto> userDto= userService.getUser(id, pw);

        if(!userDto.isPresent()) {
            return null;
        }

        List authList = new ArrayList<>();

        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new MyAuthentication(id, pw, authList, userDto.get());
    }
}
