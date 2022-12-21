package runner;

import base.BaseStepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.beers.BeersResponsePojo;
import model.beers.GetBeersRequest;
import model.beers.GetBeersResponse;
import org.junit.Assert;

import java.util.Collection;

public class BeersStepDefs extends BaseStepDefs {

    @Given("Get default beers list")
    public void getDefaultBeersList() {
        response = getRequest("");
    }

    @Given("Get beers list with per page {string}")
    public void getBeersListWithPerPage(String perPage) {
        GetBeersRequest beersRequest = new GetBeersRequest("2", perPage);
        response = getRequest(beersRequest.params);
    }

    @Given("Get single beer with id {string}")
    public void getSingleBeerWithId(String id) {
        response = getRequest(id);
    }

    @When("Response code should equal to {int}")
    public void responseCodeShouldEqualTo(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }

    @Then("Return success beers list response")
    public void returnSuccessBeersListResponse() {
        verifySuccessResponse();
    }

    @Then("Return failed beers list response")
    public void returnFailedBeersListResponse() {
        verifyFailedResponse();
    }

    @Then("Total amount data should be equals to {string}")
    public void totalAmountDataShouldBeEqualsTo(String size) {
        Collection<BeersResponsePojo> model = GetBeersResponse.toModel(response.asString());
        Assert.assertEquals(size, String.valueOf(model.size()));
    }
}