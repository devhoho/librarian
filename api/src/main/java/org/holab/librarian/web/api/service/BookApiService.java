package org.holab.librarian.web.api.service;

import org.holab.librarian.web.api.dto.*;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface BookApiService <T, R extends BookResult> {
    PageResult<R> findBooks(PageRequest<T> pageRequest) throws JSONException, IOException;
}
