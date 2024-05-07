package com.Bitts.Controller;


import com.Bitts.Configuration.JwtProvider;
import com.Bitts.Configuration.JwtService;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.User;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceaImpl userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(@RequestHeader("authorization") String jwt) throws UserException {
        System.out.println(jwt);
        jwt=jwt.substring(7);

        Claims  claims=jwtService.extractAllClaim(jwt);
        String email=claims.get("email").toString();

        User user = userService.findUserByEmail(email) ;
        System.out.println(user);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

}
