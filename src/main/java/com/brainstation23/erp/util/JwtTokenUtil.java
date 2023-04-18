package com.brainstation23.erp.util;

import java.util.Date;
import java.util.function.Function;

import com.brainstation23.erp.persistence.entity.UserEntity;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    private final String  SECRET_KEY ="secretkey";

    public String generateAccessToken(UserEntity user) {

        return Jwts.builder()
                .claim("role", user.getUserRole())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes())
                .compact();

    }
    public String extractUserEmail(String token) {
              return extractClaim(token, Claims::getSubject);
    }

           public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
              final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
          }

           private Claims extractAllClaims(String token) {
               return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    public Date extractExpiration(String token) {
              return extractClaim(token, Claims::getExpiration);
          }
   private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
           }

    public Boolean validateToken(String token, UserEntity userDetails) {
        final String userEmail = extractUserEmail(token);
               return (userEmail.equals(userDetails.getEmail()) && !isTokenExpired(token));
          }

}