package com.im.service;

import com.im.model.Token;
import com.im.repository.TokenRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenService {
    @Resource
    TokenRepository tokenRepository;
    public Token find(String token){
        Token tokenByToken = tokenRepository.findTokenByToken(token);
        return tokenByToken;
    }
}
