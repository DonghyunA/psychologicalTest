package com.sinbo.psychologicalTest.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users_roles_mapping")
public class UserRoleMapping {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private Role roleId;

    @Column
    @CreationTimestamp
    private LocalDate registerDate;

}
