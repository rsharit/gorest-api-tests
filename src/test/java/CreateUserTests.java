import Constants.ServerConstants;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.httpsRequests.CreateClientUser;
import utils.users.ClientUsers;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test(description = "Create a user successfully")
    public void shouldCreateUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        String email = "TenaliRamakrishna" + randomNum + "@tst.com";

        new CreateClientUser().createUser(name, "male", email).then()
        .log()
        .body()
        .statusCode(201)
        .body("data.name", Matchers.equalTo(name));
    }


}
