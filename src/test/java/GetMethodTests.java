
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.httpsRequests.CommonUtils;
import utils.httpsRequests.CreateClientUser;
import utils.users.pojo.GetAllUsersResponse;


public class GetMethodTests {
    CreateClientUser clientUser;
    CommonUtils commonUtils;

    @BeforeClass
    public void initiateUser(){
        //Arrange
        clientUser = new CreateClientUser();
        commonUtils = new CommonUtils();
    }


    @Test(description = "Gets the list of all users and validates the status code only")
    public void shouldGetAllUsers(){
        //Act
        Response response = clientUser.getUsersInfo();
        //Assert
        commonUtils.validateResponseCode(response, 200);
    }



    @Test(description = "Gets the list of all users and validates limit of users array is 20")
    public void getAllUsersLimitIs20(){
        //Act
        Response response = clientUser.getUsersInfo();
        //Assert
        commonUtils.validateResponseCode(response, 200);

        GetAllUsersResponse getAllUsersResponse =
                commonUtils.getResponseObject(GetAllUsersResponse.class, response);

        Assert.assertEquals(getAllUsersResponse.getData().size(), 20);


    }

}
