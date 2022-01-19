import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethodTests {
    @Test(description = "Gets the list of all users and validates the status code only")
    public void shouldGetAllUsers(){
        int statusCode = given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .getStatusCode();
        Assert.assertEquals(statusCode, 200, "Unexpected status code");
    }

    @Test(description = "Create a user")
    public void shouldCreateUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 0a5cb4fbc5ef2e2c87e1c600fd2961a2041c9cde441d69c1dc4b8137a7cc663c")
                .body("{\"name\":\"Tenali Ramakrishna\"," +
                        " \"gender\":\"male\"," +
                        " \"email\":\"tenali.ramakrishna@15ce.com\"," +
                        " \"status\":\"active\"}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then().log().body().statusCode(201);
    }
}
