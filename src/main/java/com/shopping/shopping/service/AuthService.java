package com.shopping.shopping.service;

import com.shopping.shopping.dto.LoginDto;
import com.shopping.shopping.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
