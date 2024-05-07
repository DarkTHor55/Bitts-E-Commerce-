package com.Bitts.Service.UserService;

import com.Bitts.Exception.UserException;
import com.Bitts.Model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User findUserById(Long userId) throws UserException;
    public User findUserProfileByJwt(String jwt)throws UserException;
//    public User findUserByEmail(String email)throws UserException;
//
//    public User createUser(User user) throws UserException;


}
