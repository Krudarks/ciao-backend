package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Role;
import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;
import com.sistema.ciao.sistema_ciao_backend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        Role role = userEntity.getRole(); // Supongo que getRole() devuelve un único objeto Role
        if (role != null) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole())));
            role.getPermissionList().forEach(permission -> 
            authorityList.add(new SimpleGrantedAuthority(permission.getName())));
        }

        return new User(userEntity.getName(), 
        userEntity.getPassword(),
        userEntity.getIsEnable(),
        userEntity.getAccountNoExpired(),
        userEntity.getCredentialNoExpired(),
        userEntity.getAccountLocked(), authorityList);
    }

}
