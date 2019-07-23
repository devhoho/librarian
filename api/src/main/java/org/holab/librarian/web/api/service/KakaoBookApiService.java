package org.holab.librarian.web.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.holab.librarian.web.api.config.KakaoApiConfig;
import org.holab.librarian.web.api.dto.*;
import org.holab.librarian.web.api.exception.OpenApiClientException;
import org.holab.librarian.web.api.exception.OpenApiServerException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
public class KakaoBookApiService implements BookApiService <BookRequest, KakaoBookResult> {
    @Autowired
    private KakaoApiConfig kakaoApiConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PageResult<KakaoBookResult> findBooks(PageRequest<BookRequest> pageRequest) throws IOException, JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", kakaoApiConfig.getApiKey());

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(kakaoApiConfig.getUri())
                .queryParam("query", pageRequest.getData().getKeyword())
                .queryParam("page", pageRequest.getPage())
                .build();

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            JSONObject result = new JSONObject(response.getBody());
            KakaoMeta kakaoMeta = objectMapper.readValue(result.get("meta").toString(), KakaoMeta.class);
            List<KakaoBookResult> datas = objectMapper.readValue(
                    result.get("documents").toString()
                    , TypeFactory.defaultInstance().constructCollectionType(List.class, KakaoBookResult.class));


            return PageResult.of(pageRequest.getPage(), kakaoMeta.isEnd(), datas);
        } else if (response.getStatusCode().is5xxServerError()) {
            throw new OpenApiServerException("kakao server error!");
        } else {
            throw new OpenApiClientException("client error!");
        }
    }
}
