package com.airbnb.airbnb_assignment.Service;

import com.airbnb.airbnb_assignment.Dto.UserDto;
import com.airbnb.airbnb_assignment.Model.User;
import com.airbnb.airbnb_assignment.Payload.AuthenticationResponse;
import com.airbnb.airbnb_assignment.Repository.UserRepo;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthenticationService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ModelMapper modelMapper;
//    private TokenRepository tokenRepository;

    @Autowired
    private  AuthenticationManager authenticationManager;





    public AuthenticationResponse register(   User request) {

        // check if user already exist. if exist than authenticate the user
        if(userRepo.findByUsername(request.getEmail()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist" ,request);
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setProperties(request.getProperties());
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());

        User save = userRepo.save(user);

        String jwt = jwtService.generateToken(save);

//        saveUserToken(jwt, save);

        return new AuthenticationResponse(jwt, "User registration was successful" , save );

    }

    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepo.findByUsername(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        // revokeAllTokenByUser(user);
//        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful" ,request);

    }


}
