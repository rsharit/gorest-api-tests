import Constants.ServerConstants;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethodTests {
    final String url = ServerConstants.baseUrl + ServerConstants.getEndPoint;
    @Test(description = "Gets the list of all users and validates the status code only")
    public void shouldGetAllUsers(){
        int statusCode = given()
                .when()
                .get(url)
                .getStatusCode();
        Assert.assertEquals(statusCode, 200, "Unexpected status code");
    }



    @Test(description = "Gets the list of all users and validates limit of users array is 20")
    public void getAllUsersLimitIs20(){
                given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20));

    }


}
