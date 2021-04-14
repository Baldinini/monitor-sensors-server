package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.entity.AuthRequest;
import com.example.monitorsensorsserver.entity.AuthResponse;
import com.example.monitorsensorsserver.service.user.UserPrincipalDetailsService;
import com.example.monitorsensorsserver.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

    private final AuthenticationManager authenticationManager;
    private final UserPrincipalDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public HelloController(AuthenticationManager authenticationManager, UserPrincipalDetailsService userDetailsService, JwtUtil jwtUtil) {

        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> sayHello() {

        return ResponseEntity.ok().body("Hello!");
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        String userStatus = userDetails.getAuthorities().stream().map(Object::toString).collect(Collectors.joining());
        return ResponseEntity.ok(new AuthResponse(jwt, userStatus));
    }
}
