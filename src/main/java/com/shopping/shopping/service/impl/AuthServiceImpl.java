package com.shopping.shopping.service.impl;

import com.shopping.shopping.dto.LoginDto;
import com.shopping.shopping.dto.RegisterDto;
import com.shopping.shopping.entity.Role;
import com.shopping.shopping.entity.User;
import com.shopping.shopping.exception.ProductAPIException;
import com.shopping.shopping.repository.RoleRepository;
import com.shopping.shopping.repository.UserRepository;
import com.shopping.shopping.security.JwtTokenProvider;
import com.shopping.shopping.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {

        // 유저명 중복확인
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "해당 유저명이 이미 있습니다");
        }

        // 이메일 중복확인
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new ProductAPIException(HttpStatus.BAD_REQUEST, "해당 이메일이 이미 있습니다");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "유저가 성공적으로 등록됨";
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}
