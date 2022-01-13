package com.sinbo.psychologicalTest.entity;

import com.sinbo.psychologicalTest.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Member extends BaseEntity {
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private MemberRole role;
}
