import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test(description = "Create a user")
    public void shouldCreateUser(){
        int randomNum = (int)(Math.random()*10000);
        String name = "Tenali Ramakrishna";
        String email = "TenaliRamakrishna" + randomNum + "@tst.com";
        String maleUser = getUserBody(name, "male", email);

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 0a5cb4fbc5ef2e2c87e1c600fd2961a2041c9cde441d69c1dc4b8137a7cc663c")
                .body(maleUser)
            .when()
            .post("https://gorest.co.in/public/v1/users")
            .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo(name));
    }

    private String getUserBody(String name, String gender, String email) {
        return "{\"name\":\"" + name + "\"," +
                " \"gender\":\"" + gender + "\"," +
                " \"email\":\"" + email + "\"," +
                " \"status\":\"active\"}";
    }
}
