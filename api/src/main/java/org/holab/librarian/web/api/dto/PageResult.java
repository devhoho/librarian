package org.holab.librarian.web.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PageResult<T> {
    private final int page;
    private final boolean isEnd;
    private final List<T> datas;

    private PageResult(int page, boolean isEnd, List<T> datas) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if(datas == null) {
            throw new IllegalArgumentException("Page datas must not be null!");
        }

        this.page = page;
        this.isEnd = isEnd;
        this.datas = datas;
    }

    public static <T> PageResult<T> of(int page, boolean isEnd, List<T> datas) {
        return new PageResult(page, isEnd, datas);
    }
}
