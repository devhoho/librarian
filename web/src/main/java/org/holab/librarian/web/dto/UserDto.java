package org.holab.librarian.web.dto;

import lombok.Data;

@Data
public class UserDto {
    Long no;
    String id;
    String password;
    String name;

    public UserDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
