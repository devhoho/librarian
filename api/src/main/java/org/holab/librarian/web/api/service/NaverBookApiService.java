package org.holab.librarian.web.api.service;

import org.holab.librarian.web.api.dto.BookRequest;
import org.holab.librarian.web.api.dto.NaverBookResult;
import org.holab.librarian.web.api.dto.PageRequest;
import org.holab.librarian.web.api.dto.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaverBookApiService implements BookApiService<BookRequest, NaverBookResult> {
    @Override
    public PageResult<NaverBookResult> findBooks(PageRequest<BookRequest> pageRequest) {
        return null;
    }
}
