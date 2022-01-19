
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.httpsRequests.CreateClientUser;


public class GetMethodTests {
    CreateClientUser clientUser;

    @BeforeClass
    public void initiateUser(){
        clientUser = new CreateClientUser();
    }


    @Test(description = "Gets the list of all users and validates the status code only")
    public void shouldGetAllUsers(){
        int statusCode = clientUser.getUsersInfo()
                .getStatusCode();
        Assert.assertEquals(statusCode, 200, "Unexpected status code");
    }



    @Test(description = "Gets the list of all users and validates limit of users array is 20")
    public void getAllUsersLimitIs20(){
                clientUser.getUsersInfo()
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20));

    }

}
