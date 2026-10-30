package security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {

    private static final String SECRET_KEY =
            "SOA_PROJECT_SECRET_KEY_2026_CHANGE_ME";

    private static final long EXPIRATION_TIME =
            15 * 60 * 1000; // 15 minutes

    private JWTUtil() {
    }

    public static String generateToken(String username) {

        Date now = new Date();
        Date expiration =
                new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET_KEY.getBytes()
                )
                .compact();
    }

    public static Claims validateToken(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}