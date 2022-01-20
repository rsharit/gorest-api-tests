
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.httpsRequests.CommonUtils;
import utils.httpsRequests.CreateClientUser;
import utils.users.pojo.User;

public class CreateUserTests {

    CreateClientUser clientUser;
    CommonUtils commonUtils;

    @BeforeClass
    public void initiateUser(){
        clientUser = new CreateClientUser();
        commonUtils = new CommonUtils();
    }

    @Test(description = "Create a male user successfully")
    public void shouldCreateMaleUser(){
        //Arrange
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        String email = "TenaliRamakrishna" + randomNum + "@tst.com";

        //Act
        User user = User.builder().name(name).email(email).gender("male").status("active").build();
        Response response = new CreateClientUser().createUser(user);

        //Assert
        commonUtils.validateResponseCode(response, 201);
        response.then().body("data.name", Matchers.equalTo(name));
    }

    @Test(description = "Create a female user successfully, using overloaded method to create json string")
    public void shouldCreateFemaleUser(){
        //Arrange
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenalika Ramakrishna";
        String email = "TenalikaRamakrishna" + randomNum + "@tst.com";

        //Act
        User user = User.builder().name(name).email(email).gender("female").status("active").build();
        Response response = new CreateClientUser().createUser(user);

        //Assert
        commonUtils.validateResponseCode(response, 201);
        response.then().body("data.name", Matchers.equalTo(name));
    }

}
