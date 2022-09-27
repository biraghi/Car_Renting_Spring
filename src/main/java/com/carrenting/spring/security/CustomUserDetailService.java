package com.carrenting.spring.security;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserFromUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }

        UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPassword());

        String profilo;
        if(user.getAdmin()){
            profilo = "ROLE_ADMIN";
        }
        else{
            profilo = "ROLE_USER";
        }

        builder.authorities(profilo);

        return builder.build();
    }
}
