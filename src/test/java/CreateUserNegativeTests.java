import Constants.ServerConstants;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.httpsRequests.CreateClientUser;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {
    final String url = ServerConstants.baseUrl + ServerConstants.postEndPoint;

    @Test(description = "Create a user and then create duplicate user.")
    public void shouldNotCreateDuplicateUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        String email = "TenaliRamakrishna" + randomNum + "@tst.com";

        // Trying user first time
        new CreateClientUser().createUser(name, "male", email).then()
                .log()
                .body()
                .statusCode(201);

        // Trying to create duplicate user
        new CreateClientUser().createUser(name, "male", email).then()
                .log()
                .body()
                .statusCode(422)
                .body("data", Matchers.hasItem( Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "has already been taken")));
    }
}
