package org.holab.librarian.rdb.repository;

import org.holab.librarian.rdb.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        String name = "test_name";
        String password = "test_pw";
        User user = userRepository.save(User.builder()
                .name(name)
                .password(password)
                .build());

        assertThat(user.getName(), equalTo(name));
        assertThat(user.getPassword(), equalTo(password));

        assertFalse(userRepository.findAll().isEmpty());
    }
}