package com.brainstation23.erp.service;

import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.persistence.repository.UserRepository;
import com.brainstation23.erp.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    public static final String USER_NOT_FOUND = "User Not Found";

    public ResponseEntity<String> getJwtToken(String email, String password){
        var entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
        if(entity.getPassword().equals(password)){
            return new ResponseEntity<String>(jwtTokenUtil.generateAccessToken(entity), HttpStatus.OK);
        }
        else{
            throw new IllegalArgumentException("User name or password is incorrect");
        }

    }

}
