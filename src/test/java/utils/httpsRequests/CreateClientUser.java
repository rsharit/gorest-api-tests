package utils.httpsRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Constants.ServerConstants;
import utils.users.pojo.User;

import static io.restassured.RestAssured.given;

public class CreateClientUser {
    final String url =  ServerConstants.baseUrl + ServerConstants.postEndPoint;

    public Response createUser(User user){
        //String userInfo = getUserBody(name, gender, email);
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        ServerConstants.AccessToken)
                .body(user)
                .when()
                .post(url);
    }

    public Response getUsersInfo(){
        return given()
                .when()
                .get(url);
    }

}
