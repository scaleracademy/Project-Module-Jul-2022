package com.scaler.blogger.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private ModelMapper modelMapper;
    private UserJwtService jwtService;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper, UserJwtService jwtService) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    /**
     * signup user
     */
    public UserDTO.LoginUserResponse signupUser(UserDTO.CreateUserRequest user) {
        // TODO: check for invalid inputs and non unique username/email
        UserEntity savedUser = usersRepository.save(modelMapper.map(user, UserEntity.class));
        UserDTO.LoginUserResponse response = modelMapper.map(savedUser, UserDTO.LoginUserResponse.class);
        response.setToken(jwtService.createJwtToken(response.getUsername()));
        return response;
    }

    /**
     * login user
     */
    public UserDTO.LoginUserResponse loginUser(UserDTO.LoginUserRequest user) {

        UserEntity userEntity = usersRepository.findByUsername(user.getUsername()).orElseThrow(
                () -> new UserNotFoundException(user.getUsername())
        );

        // TODO: match password using hashing
        if (userEntity.getPassword().equals(user.getPassword())) {
            UserDTO.LoginUserResponse response = modelMapper.map(userEntity, UserDTO.LoginUserResponse.class);
            response.setToken(jwtService.createJwtToken(response.getUsername()));
            return response;
        } else {
            throw new UserAuthenticationException();
        }
    }

    /**
     * get user by username
     */
    public UserDTO.GetUserResponse getUserByUsername(String username) {
        UserEntity userEntity = usersRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(username)
        );
        return modelMapper.map(userEntity, UserDTO.GetUserResponse.class);
    }

    public UserEntity getUserEntityByUsername(String username) {
        UserEntity userEntity = usersRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(username)
        );
        return userEntity;
    }

    static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String username) {
            super("No such user found with username: " + username);
        }
    }

    static class UserAuthenticationException extends SecurityException {
        public UserAuthenticationException() {
            super("Authentication Failed");
        }
    }
}
