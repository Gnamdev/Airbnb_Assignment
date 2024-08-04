package com.project.controller;


import com.airbnb.airbnb_assignment.Model.User;
import com.airbnb.airbnb_assignment.Payload.AuthenticationResponse;
import com.airbnb.airbnb_assignment.Service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;
    private static final Logger  logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody User request
    ) {
        logger.info("Signup request received for user: {}", request.getUsername());
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(


            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
