package com.nerlin.oauthjwtlib;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtTokenValidator {

    private String secretKey;

    public JwtTokenValidator(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Valida il token JWT e restituisce i claim.
     * 
     * @param token Il token JWT da validare
     * @return I claim estratti dal token
     * @throws SignatureException se il token non è valido
     */
    public Claims validateToken(String token) throws SignatureException {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
