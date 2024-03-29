package com.sinbo.psychologicalTest.entity.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
public class User implements UserDetails {
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] userRoles = convert(getUserRoleMappingList());
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
    public String[] convert(List<UserRoleMapping> list){
        String[] arrayOfStrings = new String[list.size()];

        int index = 0;
        for (UserRoleMapping userRoleMapping : list) {
            arrayOfStrings[index++] = userRoleMapping.getRole().getRole();
        }
        return arrayOfStrings;
    }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
