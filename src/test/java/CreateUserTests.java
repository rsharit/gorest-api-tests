
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.httpsRequests.CreateClientUser;
import utils.users.pojo.User;

public class CreateUserTests {

    @Test(description = "Create a male user successfully")
    public void shouldCreateMaleUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        String email = "TenaliRamakrishna" + randomNum + "@tst.com";

        //User user = new User(name,email, "male", "active");
        User user = User.builder().name(name).email(email).gender("male").status("active").build();
        new CreateClientUser().createUser(user).then()
        .log()
        .body()
        .statusCode(201)
        .body("data.name", Matchers.equalTo(name));
    }

    @Test(description = "Create a female user successfully, using overloaded method to create json string")
    public void shouldCreateFemaleUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenalika Ramakrishna";
        String email = "TenalikaRamakrishna" + randomNum + "@tst.com";

        new CreateClientUser().createUser(name, "female", email).then()
                .log()
                .body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo(name));
    }

}
