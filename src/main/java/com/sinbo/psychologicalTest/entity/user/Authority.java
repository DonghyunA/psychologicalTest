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
@Table(name = "authorities")
public class Authority {
    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String authority;

    @Column
    @CreationTimestamp
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "authority", fetch = FetchType.LAZY)
    private List<RoleAuthorityMapping> roleAuthorityMappingList = new ArrayList<>();
}
