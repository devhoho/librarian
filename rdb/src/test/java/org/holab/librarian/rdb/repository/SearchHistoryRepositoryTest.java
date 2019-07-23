package org.holab.librarian.rdb.repository;

import org.holab.librarian.rdb.domain.SearchHistory;
import org.holab.librarian.rdb.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchHistoryRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    private User defaultUser;

    @Before
    public void setup() {
        defaultUser = userRepository.save(
                User.builder()
                        .name("name")
                        .password("password")
                        .build()
        );
    }

    @Test
    @Transactional
    public void test() {
        SearchHistory searchHistory = searchHistoryRepository.save(
                SearchHistory.builder()
                        .user(defaultUser)
                        .keyword("test_keyword")
                        .searchDateTime(LocalDateTime.now())
                .build()
        );

        assertFalse(searchHistoryRepository.findAll().isEmpty());
    }

    @Test
    @Transactional
    public void findAllByUserNoTest() {
        SearchHistory searchHistory = searchHistoryRepository.save(
                SearchHistory.builder()
                        .user(defaultUser)
                        .keyword("test_keyword")
                        .searchDateTime(LocalDateTime.now())
                        .build()
        );

        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAllByUserNo(defaultUser.getNo());

        assertFalse(searchHistoryList.isEmpty());
    }
}
