package org.holab.librarian.web.api.service;

import org.holab.librarian.web.api.dto.NaverBookResult;
import org.holab.librarian.web.api.dto.PageRequest;

import java.util.List;

public class BookSearchService {
    BookApiService bookApiService;

    public List<NaverBookResult> search(PageRequest pageRequest) {
        try {
            bookApiService.findBooks(pageRequest);
        } catch(Exception e) {

        }
        return null;
    }
}
