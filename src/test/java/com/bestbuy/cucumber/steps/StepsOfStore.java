package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class StepsOfStore {
    static String name = "Cambridge" + TestUtils.getRandomValue();
    static String type = "BigBox" + TestUtils.getRandomValue();
    static String address = "Hilton Rd.";
    static String address2 = "Cambridge";
    static String city = "Cambridge";
    static String state = "Cambridgeshire";
    static String zip = "CB4 3NB";
    static Double lat = 44.969658;
    static Double lng = -93.449539;
    static String hours = "Mon: 10-9; Tue: 10-9, Wed: 10-9, Thurs: 10-9, Fri: 10-9, Sat: 10-9, Sun: 10-8";
    static int storeId;

    ValidatableResponse response;
    @Steps
    StoreSteps storeSteps;

    @When("^As a User I create a store$")
    public void asAUserICreateAStore() {
      response=storeSteps.createStore(name,type,address,address2,city,state,zip,lat,lng,hours);
    storeId=(int) response.extract().path("id");
    }

    @Then("^User must get a valid response 201$")
    public void userMustGetAValidResponse() {
        response.statusCode(201);
    }

    @When("^I get store with storeId$")
    public void iGetStoreWithStoreId() {
        response=storeSteps.getStudentById(storeId);
    }

    @And("^I must get back a valid response$")
    public void iMustGetBackAValidResponse() {
        response.statusCode(200);
    }

    @When("^I update store with storeId$")
    public void iUpdateStoreWithStoreId() {
        type="bigBox";
        response=storeSteps.updateStore(storeId,name,type,address,address2,city,state,zip,lat,lng,hours);
    }

    @Then("^I must get back again valid response$")
    public void iMustGetBackAgainValidResponse() {
        response.statusCode(200);
    }

    @When("^I delete store with storeId$")
    public void iDeleteStoreWithStoreId() {
        response=storeSteps.deleteStore(storeId).statusCode(200);
    }

    @And("^I check store is deleted$")
    public void iCheckStoreIsDeleted() {
        response=storeSteps.getStudentById(storeId).statusCode(404);
    }
}
