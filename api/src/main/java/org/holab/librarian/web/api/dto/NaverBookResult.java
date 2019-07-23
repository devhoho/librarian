package org.holab.librarian.web.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NaverBookResult implements BookResult{
    private String title;
    private String thumbnail;
    private String contents;
    private String isbn;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private Integer price;
    private Integer salePrice;
}
