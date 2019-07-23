package org.holab.librarian.web.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class KakaoBookResult implements BookResult{
    private String title;
    private String thumbnail;
    private String contents;
    private String isbn;
    private List<String> authors;
    private List<String> translators;
    private String publisher;
    @JsonProperty("datetime")
    private LocalDateTime publishDateTime;
    private Integer price;
    private Integer salePrice;
}
