package com.xebia.studentevaluationapp.controller;

import org.springframework.web.bind.annotation.*;

import com.xebia.studentevaluationapp.util.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public String authenticate(@RequestBody String username) {
        // Add authentication logic here
        return jwtUtil.generateToken(username);
    }
}
