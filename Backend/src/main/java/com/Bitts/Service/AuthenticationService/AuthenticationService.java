package com.Bitts.Service.AuthenticationService;


import com.Bitts.Configuration.JwtService;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Cart;
import com.Bitts.Model.User;
import com.Bitts.Repository.UserRepository;
import com.Bitts.Response.AuthResponse;
import com.Bitts.Request.LoginRequest;
import com.Bitts.ServiceImpl.CartServiceImpl;
import com.Bitts.ServiceImpl.CustomUserDetailsService;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private UserServiceaImpl   userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse CreateUser(User user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        User isEmailExists = userService.findUserByEmail(email);
        if (isEmailExists!=null) {
            throw new UserException("Email already exists");
        }
        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setFirstName(firstName);
        createdUser.setLastName(lastName);
        createdUser.setCreateAT(LocalDateTime.now());
        createdUser.setRole("User");
        createdUser.setPhoneNumber(user.getPhoneNumber());
        User savedUser = userRepository.save(createdUser);
        Cart cart=cartService.createCart(savedUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("User created successfully");

        return authResponse;

    }


    public LoginRequest loginUser(LoginRequest login) throws UserException {


        User user = userService.findUserByEmail(login.getEmail());

        LoginRequest loginRequest = null;

        if(user != null){
            if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            throw new UserException("Invalid password");

            }else {
                Authentication auth = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());

                String jwt=jwtService.generateToken(auth);

                new ResponseEntity<>(new AuthResponse(jwt,"TOKEN"),HttpStatus.OK);

                return new LoginRequest(login.getEmail(), login.getPassword(),jwt);

            }
        }
        return loginRequest ;
    }



    }
