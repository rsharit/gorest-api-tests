package utils.httpsRequests;

import io.restassured.response.Response;
import org.testng.Assert;



public class CommonUtils {

    public void validateResponseCode(Response response, int expectedStatusCode){
        printResponse(response);
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    private void printResponse(Response response){
        response.then().log().body();
    }

    public <T> T getResponseObject(Class<T>  responseClass, Response response){
        return response.as(responseClass);
    }

}
