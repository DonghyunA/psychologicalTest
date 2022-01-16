package com.sinbo.psychologicalTest.service.security;

import com.sinbo.psychologicalTest.dto.UserDTO;
import com.sinbo.psychologicalTest.entity.user.User;
import com.sinbo.psychologicalTest.entity.user.UserRoleMapping;
import com.sinbo.psychologicalTest.repo.UserRepository;
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
public class PsyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User usr =  userRepository.findByEmail(email);
        UserDTO userDTO = new UserDTO(usr.getEmail(), usr.getPwd());
        return userDTO;
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


