package com.nerlin.oauthjwtlib;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RoleBasedAccessTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testAdminAccessToProtectedResource() {
        String adminToken = "eyJhbGci...";  // Inserisci qui un token JWT di un utente con ruolo admin

        given()
            .header("Authorization", "Bearer " + adminToken)
            .when()
            .get("/api/admin/resource")
            .then()
            .statusCode(200)  // Verifica che l'accesso sia consentito
            .body("message", equalTo("Access granted to admin"));
    }
    
    @Test
    public void testUserAccessDeniedToAdminResource() {
        String userToken = "eyJhbGci...";  // Inserisci qui un token JWT di un utente con ruolo normale

        given()
            .header("Authorization", "Bearer " + userToken)
            .when()
            .get("/api/admin/resource")
            .then()
            .statusCode(403)  // Verifica che l'accesso sia negato
            .body("message", equalTo("Access denied"));
    }
}
