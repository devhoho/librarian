package org.holab.librarian.web.security;

import lombok.Getter;
import lombok.Setter;
import org.holab.librarian.web.dto.UserDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

@Setter
@Getter
public class MyAuthentication extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID =1L;
    UserDto userDto;

    public MyAuthentication(String id, String pw, List authList, UserDto userDto) {
        super(id, pw, authList);
        this.userDto = userDto;
    }
}
