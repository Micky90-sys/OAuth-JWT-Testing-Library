package com.nerlin.oauthjwtlib;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuthTestHelper {

    private String baseUri;

    public OAuthTestHelper(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * Effettua il login e restituisce il token JWT.
     * 
     * @param email    L'email dell'utente
     * @param password La password dell'utente
     * @return Il token JWT
     */
    public String login(String email, String password) {
        String loginPayload = "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
        
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(loginPayload)
                .post(baseUri + "/api/auth/login")
                .then()
                .statusCode(200)
                .extract().response();

        return response.path("token");
    }

    /**
     * Esegue la richiesta per un nuovo token tramite il refresh token.
     * 
     * @param refreshToken Il refresh token
     * @return Il nuovo token JWT
     */
    public String refreshToken(String refreshToken) {
        String refreshPayload = "{ \"refreshToken\": \"" + refreshToken + "\" }";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(refreshPayload)
                .post(baseUri + "/api/auth/refresh-token")
                .then()
                .statusCode(200)
                .extract().response();

        return response.path("token");
    }
}
