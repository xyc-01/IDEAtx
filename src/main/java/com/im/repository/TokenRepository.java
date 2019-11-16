package com.im.repository;

import com.im.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findTokenByToken(String token);
}
