package com.Bitts.Controller;

import com.Bitts.Configuration.JwtService;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.User;
import com.Bitts.Repository.UserRepository;
import com.Bitts.Request.LoginRequest;
import com.Bitts.Response.AuthResponse;
import com.Bitts.Service.AuthenticationService.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JwtService jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        AuthResponse authentication = authenticationService.CreateUser(user);
        return new ResponseEntity<AuthResponse>(authentication, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRequest> LoginUserHandler(@RequestBody LoginRequest login) throws UserException {
        LoginRequest loginRequest =authenticationService.loginUser(login);
        if(loginRequest == null){
            return new ResponseEntity<LoginRequest>(HttpStatus.BAD_REQUEST);


        }

        return new ResponseEntity<LoginRequest>(loginRequest, HttpStatus.CREATED.OK);

    }



}
