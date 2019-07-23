package org.holab.librarian.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class KakaoMeta {
    int totalCount;
    int pageableCount;
    boolean isEnd;
}
