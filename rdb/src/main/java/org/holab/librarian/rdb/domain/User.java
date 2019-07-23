package org.holab.librarian.rdb.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(of = {"no", "name", "createDateTime", "updateDateTime"})
public class User {
    @Id
    @GeneratedValue
    private Long no;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Builder
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
