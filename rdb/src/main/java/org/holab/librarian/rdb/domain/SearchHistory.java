package org.holab.librarian.rdb.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(of = {"no", "user", "keyword", "searchDateTime"})
public class SearchHistory {
    @Id
    @GeneratedValue
    private Long no;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name="user_no")
    private User user;
    @Column(nullable = false)
    private String keyword;
    @Column(nullable = false)
    private LocalDateTime searchDateTime;

    @Builder
    public SearchHistory(User user, String keyword, LocalDateTime searchDateTime) {
        this.user = user;
        this.keyword = keyword;
        this.searchDateTime = searchDateTime;
    }
}
