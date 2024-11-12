package com.pirates.pirates_crew.controller;

import com.pirates.pirates_crew.model.Role;
import com.pirates.pirates_crew.model.User;
import com.pirates.pirates_crew.repostory.UserRepository;
import com.pirates.pirates_crew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username,
                                           @RequestParam String password,
                                           @RequestParam Role role) {
        userService.registerUser(username, password, role);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }
}