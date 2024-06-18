package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Role;
import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;
import com.sistema.ciao.sistema_ciao_backend.repository.UserRepository;
import com.sistema.ciao.sistema_ciao_backend.rest.dto.AuthLoginRequest;
import com.sistema.ciao.sistema_ciao_backend.rest.dto.AuthResponse;
import com.sistema.ciao.sistema_ciao_backend.util.JwtUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String userName = authLoginRequest.userName();
        String passWord = authLoginRequest.password();

        Authentication authentication = this.authenticate(userName, passWord);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(userName, "User logged succesfuly", accesToken, true);
        return authResponse;
    }

    public Authentication authenticate(String userName, String passWord){
        UserDetails userDetails = this.loadUserByUsername(userName);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(passWord, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userName, userDetails.getPassword(), userDetails.getAuthorities());
    }

}
