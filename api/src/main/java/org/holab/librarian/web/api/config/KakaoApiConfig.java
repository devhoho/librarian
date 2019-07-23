package org.holab.librarian.web.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class KakaoApiConfig {
    @Value("${api.book.kakao.key}")
    private String apiKey;

    @Value("${api.book.kakao.uri}")
    private String uri;
}
