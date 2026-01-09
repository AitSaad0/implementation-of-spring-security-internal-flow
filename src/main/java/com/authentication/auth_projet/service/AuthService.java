package com.authentication.auth_projet.service;


import com.authentication.auth_projet.dto.LoginRequest;
import com.authentication.auth_projet.dto.RegisterRequest;
import com.authentication.auth_projet.entity.User;
import com.authentication.auth_projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    public String register(RegisterRequest request) {

        if(userRepository.findByUsername(request.username()).isPresent()){
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(request.username());
        user.setRole("ROLE_PLAYER");
        user.setPass_hash(passwordEncoder.encode(request.password()));
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(LoginRequest request){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );
            return "Login successful";
        }catch (AuthenticationException e){
            return "Invalid username or password";
        }
    }

}