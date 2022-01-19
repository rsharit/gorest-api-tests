package utils.httpsRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Constants.ServerConstants;

import static io.restassured.RestAssured.given;

public class CreateClientUser {
    final String url =  ServerConstants.baseUrl + ServerConstants.postEndPoint;

    /**
     *
     * @param name
     * @param gender
     * @param email
     * @return
     */
    public Response createUser(String name, String gender, String email){
        String userInfo = getUserBody(name, gender, email);
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        ServerConstants.AccessToken)
                .body(userInfo)
                .when()
                .post(url);
    }

    public Response getUsersInfo(){
        return given()
                .when()
                .get(url);
    }

    /**
     * This method is used to create user body needed for post request
     * @param name
     * @param gender
     * @param email
     * @return
     */
    private String getUserBody(String name, String gender, String email) {
        return "{\"name\":\"" + name + "\"," +
                " \"gender\":\"" + gender + "\"," +
                " \"email\":\"" + email + "\"," +
                " \"status\":\"active\"}";
    }
}
