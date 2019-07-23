package org.holab.librarian.web.api.dto;

import lombok.Getter;

@Getter
public class PageRequest<T> {
    private final int page;
    private final int size;
    private final T data;

    private PageRequest(int page, int size, T data) {
        if (page < 1) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if(size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }

        if(data == null) {
            throw new IllegalArgumentException("Page data must not be null!");
        }
        this.page = page;
        this.size = size;
        this.data = data;
    }

    public static <T> PageRequest<T> of(int page, int size, T data) {
        return new PageRequest<>(page, size, data);
    }

}
