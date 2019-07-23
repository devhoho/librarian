package org.holab.librarian.web.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.holab.librarian.web.api.config.KakaoApiConfig;
import org.holab.librarian.web.api.dto.BookRequest;
import org.holab.librarian.web.api.dto.KakaoBookResult;
import org.holab.librarian.web.api.dto.PageRequest;
import org.holab.librarian.web.api.dto.PageResult;
import org.holab.librarian.web.api.exception.OpenApiServerException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class KakaoBookApiServiceTest {
//    @Mock
//    KakaoApiConfig kakaoApiConfig;

    @Mock
    RestTemplate restTemplate;

    @Mock
    ObjectMapper objectMapper;

    @InjectMocks
    KakaoBookApiService kakaoBookApiService;

    @Test(expected = OpenApiServerException.class)
    public void givenServerError_whenFindBooks_thenOpenApiServerException() throws IOException, JSONException {
        given(restTemplate.exchange(anyString(), HttpMethod.GET, new HttpEntity<String>(any(HttpHeaders.class)), String.class))
        .willReturn(new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR));

        kakaoBookApiService.findBooks(PageRequest.of(1, 50, new BookRequest("test")));
    }
}