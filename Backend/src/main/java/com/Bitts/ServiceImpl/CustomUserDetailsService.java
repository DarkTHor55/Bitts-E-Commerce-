package com.Bitts.ServiceImpl;

import com.Bitts.Exception.UserException;
import com.Bitts.Model.User;
import com.Bitts.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceaImpl  userService;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return  userService.findUserByEmail(username);
        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

}
