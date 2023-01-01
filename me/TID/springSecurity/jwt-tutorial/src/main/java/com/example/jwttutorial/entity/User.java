package com.example.jwttutorial.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity // 데이터베이스와 1:1 매핑되는 객체를 뜻함
@Table(name = "users") // 테이블 명을 user로 지정
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany // 유저 객체와 권한 객체의 일대다, 다대일 관계의 조인테이블을 만들었다는 뜻
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
