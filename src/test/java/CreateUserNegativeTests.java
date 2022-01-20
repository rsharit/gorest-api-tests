import Constants.ServerConstants;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.httpsRequests.CommonUtils;
import utils.httpsRequests.CreateClientUser;
import utils.users.pojo.User;


public class CreateUserNegativeTests {

    CreateClientUser clientUser;
    CommonUtils commonUtils;

    @BeforeClass
    public void initiateUser(){
        clientUser = new CreateClientUser();
        commonUtils = new CommonUtils();
    }

    @Test(description = "Create a user and then create duplicate user.")
    public void shouldNotCreateDuplicateUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        String email = "TenaliRamakrishna" + randomNum + "@tst.com";

        //Act
        // Trying user first time
        User user = User.builder().name(name).email(email).gender("female").status("active").build();
        Response response = new CreateClientUser().createUser(user);
        commonUtils.validateResponseCode(response, 201);

        // Trying to create duplicate user
        response = new CreateClientUser().createUser(user);

        //Assert
        commonUtils.validateResponseCode(response, 422);
        response.then().body("data", Matchers.hasItem( Matchers.hasEntry("field", "email")));
        response.then().body("data", Matchers.hasItem(Matchers.hasEntry("message", "has already been taken")));
    }
}
