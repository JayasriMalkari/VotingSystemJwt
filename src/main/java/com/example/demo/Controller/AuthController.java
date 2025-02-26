package com.example.demo.Controller;

import com.example.demo.DTO.AuthResponse;
import com.example.demo.DTO.RegisterUserDto;
import com.example.demo.Entity.User;
import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.JwtService;
import com.example.demo.Service.UserDetailsServiceImpl;

import com.example.demo.DTO.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginUserDto authRequest) {
        // Authenticate the user based on the provided credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        // If authentication is successful, generate a JWT token
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtService.generateToken(userDetails);
        // Return the JWT in the response
        AuthResponse authResponse = new AuthResponse(jwt);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserDto authRequest) {
        // Register the user (You can integrate with your user service to save user details)
        // For example, save the user to the database.
        User registeredUser = authenticationService.signup(authRequest);

        // Dummy response for illustration, in a real app you'd want to implement this logic
        return ResponseEntity.ok("User registered successfully.");
    }
}