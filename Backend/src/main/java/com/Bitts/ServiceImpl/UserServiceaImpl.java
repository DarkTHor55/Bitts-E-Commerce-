package com.Bitts.ServiceImpl;

import com.Bitts.Configuration.JwtProvider;
import com.Bitts.Configuration.JwtService;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.User;
import com.Bitts.Repository.UserRepository;
import com.Bitts.Service.UserService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceaImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceaImpl.class);
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceaImpl userService;



    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User>user  = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserException("User not found ID :"+userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email= jwtProvider.findEmailByJwt(jwt);
//        String email = jwtService.extractEmailFromJwt(jwt);
        logger.info("email h y " +email);
        User user= userService.findUserByEmail(email);
        if(user==null){
            throw new UserException("User not found"+email);
        }
        return user;

    }
    public User findUserByEmail(String email) throws UserException{
        List<User> newUsers =userRepository.findAll();
        for(User user:newUsers){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;

    }

}
