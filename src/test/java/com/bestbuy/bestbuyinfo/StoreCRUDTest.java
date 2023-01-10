package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class StoreCRUDTest extends TestBase {
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

    @Steps
    StoreSteps storeSteps;

    @Title("This will create new  store")
    @Test
    public void test001() {
        ValidatableResponse response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours);
        response.log().all().statusCode(201);
        storeId=response.extract().path("id");
        System.out.println(storeId);
    }

    @Title("Getting the store information with Name:")
    @Test
    public void test002() {
ValidatableResponse response=storeSteps.getStudentById(storeId).statusCode(200);
//        HashMap<String, Object> storeMap = storeSteps.getStoreByName(name);
//        Assert.assertThat(storeMap, hasValue(name));

    }

    @Title("Updating store information and verify the updated information")
    @Test
    public void test003() {
        name = name + ("_added");
        storeSteps.updateStore(storeId, name, type, address, address2, city, state, zip, lat, lng, hours).log().all().statusCode(200);

    }

    @Title("Deleting store with id and verify that user is deleted")
    @Test
    public void test004() {
        storeSteps.deleteStore(storeId).statusCode(200);
        storeSteps.getStudentById(storeId).statusCode(404);

    }
}
