package com.sinbo.psychologicalTest.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String role;

    @Column
    @CreationTimestamp
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserRoleMapping> userRoleMappingList = new ArrayList<>();

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<RoleAuthorityMapping> roleAuthorityMappingList = new ArrayList<>();
}
