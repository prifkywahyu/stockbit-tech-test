package base;

import config.GlobalVariable;
import config.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.base.ErrorResponse;
import model.beers.BeersResponsePojo;
import model.beers.GetBeersResponse;
import org.junit.Assert;

import java.util.Collection;

public abstract class BaseStepDefs {

    public Response response;
    public GlobalVariable globalVariable = GlobalVariable.getInstance();

    private RequestSpecification createRequest() {
        return RestAssured.given();
    }

    public Response getRequest(String path) {
        String url = globalVariable.baseUrl;
        if (!path.isEmpty()) {
            System.out.println("Get Request: " + url);
            System.out.println("Path: " + path);
        } else {
            System.out.println("Get Request: " + url);
        }
        return createRequest().get(url + path);
    }

    public void verifySuccessResponse() {
        Collection<BeersResponsePojo> model = GetBeersResponse.toModel(response.asString());
        StatusCode statusCode = StatusCode.getCode(response.getStatusCode());
        Assert.assertFalse(model.isEmpty());
        System.out.println("Total Data: " + model.size());
        System.out.println("Status Code: " + statusCode.getValue());
        System.out.println("Response: \n" + response.asPrettyString());
    }

    public void verifyFailedResponse() {
        ErrorResponse model = ErrorResponse.toModel(response.asString());
        StatusCode statusCode = StatusCode.getCode(response.getStatusCode());
        Assert.assertNotNull(model.error);
        Assert.assertNotNull(model.message);
        System.out.println("Status Code: " + statusCode.getValue());
        System.out.println("Error: " + model.error);
        System.out.println("Message: " + model.message);
    }
}