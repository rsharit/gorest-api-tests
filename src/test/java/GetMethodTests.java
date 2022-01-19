import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethodTests {
    @Test
    public void getUsers(){
        int statusCode = given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .getStatusCode();
        Assert.assertEquals(statusCode, 200, "Unexpected status code");
    }
}
