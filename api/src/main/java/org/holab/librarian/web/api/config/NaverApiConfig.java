package org.holab.librarian.web.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NaverApiConfig {
    @Value("${api.book.naver.client-id}")
    private String clientId;

    @Value("${api.book.naver.client-key}")
    private String clientKey;
}
