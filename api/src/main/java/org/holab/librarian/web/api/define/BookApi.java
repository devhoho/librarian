package org.holab.librarian.web.api.define;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@RequiredArgsConstructor
public enum BookApi {
    KAKAO
    , NAVER
}
