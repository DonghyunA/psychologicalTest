package com.sinbo.psychologicalTest.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "roles_authorities_mapping")
public class RoleAuthorityMapping {
    @Id
    @Column
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autherity_id", referencedColumnName = "id")
    private Authority authority;

    @Column
    @CreationTimestamp
    private LocalDate registerDate;
}
