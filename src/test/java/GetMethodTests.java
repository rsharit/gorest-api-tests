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


}
