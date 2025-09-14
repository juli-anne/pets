package com.julianne.pets.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;

import javax.crypto.SecretKey;
import java.util.Date;

public class jwtUtil {

    public static String generateToken(User user) {

        return Jwts
                .builder()
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 300_000))
                .signWith(getSigningKey())
                .compact();

    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static boolean isTokenValid(String token) {
        return !isExpired(token);
    }

    private static boolean isExpired(String token) {
        return getClaimsFromToken(token)
                .getExpiration().
                before(new Date());
    }

    private static SecretKey getSigningKey() {

        byte[] keyBytes = Decoders.BASE64.decode("yoursecretkeythathastobelongenoguhforsecurity");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
