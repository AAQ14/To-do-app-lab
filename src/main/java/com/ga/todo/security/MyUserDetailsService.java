package com.ga.todo.security;

import com.ga.todo.model.User;
import com.ga.todo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//    Security Packages -- classes
//    our class -> implements -> spring security interface
//    myuserdetailsservice userdetailsservice
//    myuserdetails     userdetails
//    securtyconfigurtion(implements which urls should be allowed and which not)
@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmailAddress(email);
        return new MyUserDetails(user);
    }
}
