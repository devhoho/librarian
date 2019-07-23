package org.holab.librarian.rdb.repository;

import org.holab.librarian.rdb.domain.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    List<SearchHistory> findAllByUserNo(Long userno);
}
