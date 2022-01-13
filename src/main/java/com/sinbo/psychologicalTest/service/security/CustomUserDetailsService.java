package com.sinbo.psychologicalTest.service.security;

import com.sinbo.psychologicalTest.entity.user.User;
import com.sinbo.psychologicalTest.entity.user.UserRoleMapping;
import com.sinbo.psychologicalTest.repo.UserRepository;
import com.sinbo.psychologicalTest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(long userId) throws UsernameNotFoundException {
        User user = userService.findbyId(userId);
        return new User(user.getId(), user.getPwd(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user){
        String[] userRoles = convert(user.getUserRoleMappingList());
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    public String[] convert(List<UserRoleMapping> list){
        String[] arrayOfStrings = new String[list.size()];

        int index = 0;
        for (UserRoleMapping userRoleMapping : list) {
            arrayOfStrings[index++] = userRoleMapping.getRoleId().getRole();
        }
        return arrayOfStrings;
    }
}


