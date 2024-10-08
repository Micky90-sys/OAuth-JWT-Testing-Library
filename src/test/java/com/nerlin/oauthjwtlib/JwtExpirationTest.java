package com.nerlin.oauthjwtlib;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JwtExpirationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testExpiredJwtToken() {
        String expiredToken = "eyJhbGci...";  // Inserisci qui un token scaduto valido

        given()
            .header("Authorization", "Bearer " + expiredToken)
            .when()
            .get("/api/protected-resource")
            .then()
            .statusCode(401)  // Verifica che l'accesso sia negato
            .body("message", equalTo("Token is expired"));
    }
}
