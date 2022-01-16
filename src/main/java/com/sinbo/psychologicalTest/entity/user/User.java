package com.sinbo.psychologicalTest.entity.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String usr;
    @Column(nullable = false)
    private String pwd;
    @Column(nullable = false)
    private String nickName;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    private long createdAt;

    @Column
    private long createdBy;

    @Column
    private long lastModifiedAt;

    @Column
    private long lastModifiedBy;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRoleMapping> userRoleMappingList;


}
