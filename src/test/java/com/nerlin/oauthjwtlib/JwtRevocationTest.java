package com.nerlin.oauthjwtlib;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JwtRevocationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testRevokedJwtToken() {
        String revokedToken = "eyJhbGci...";  // Inserisci qui un token revocato valido

        given()
            .header("Authorization", "Bearer " + revokedToken)
            .when()
            .get("/api/protected-resource")
            .then()
            .statusCode(401)  // Verifica che l'accesso sia negato
            .body("message", equalTo("Token has been revoked"));
    }
}
