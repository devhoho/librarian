package org.holab.librarian.web.service;

import lombok.RequiredArgsConstructor;
import org.holab.librarian.web.dto.UserDto;
import org.holab.librarian.rdb.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;


    public Optional<UserDto> getUser(String id) {
        return Optional.empty();
    }

    public Optional<UserDto> getUser(String id, String pw) {
        Optional<UserDto> userDto = userRepository.findOneById(id).map(v -> modelMapper.map(v, UserDto.class));

        if(userDto.isPresent() && pw.equals(userDto.get().getPassword())) {
            return userDto;
        } else {
            return Optional.empty();
        }
    }
}
