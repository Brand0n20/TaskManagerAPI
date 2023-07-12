package ToDoList.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service    // transforms it into a managed bean
public class JwtService {

    private static final String SECRET_KEY = "fVxQxirBExW5Ve5HPDCB9LyZXifDWKAZ";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // the email should be the subject of the token
    }

    private Claims extractAllClaims(String token) {
        return Jwts.
                parserBuilder()
                .setSigningKey(getSigningKey()) // signing key is a secret used to digitally sign the jwt
                .build()                // to verify that the sender is who they claim to be
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Extract a single claim that's pass
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);     // token only for user details and no claims
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
       return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)).signWith(getSigningKey(), SignatureAlgorithm.HS256)
               .compact();
    }

}
