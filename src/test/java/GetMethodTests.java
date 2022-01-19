import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
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



    @Test(description = "Gets the list of all users and validates limit of users array is 20")
    public void getAllUsersLimitIs20(){
                given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20));

    }

    @Test(description = "Create a user")
    public void shouldCreateUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 0a5cb4fbc5ef2e2c87e1c600fd2961a2041c9cde441d69c1dc4b8137a7cc663c")
                .body("{\"name\":\""+ name+"\"," +
                        " \"gender\":\"male\"," +
                        " \"email\":\"tenali.ramakrishna" + randomNum + "@15ce.com\" ," +
                        " \"status\":\"active\"}")
            .when()
            .post("https://gorest.co.in/public/v1/users")
            .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo(name));
    }
}
