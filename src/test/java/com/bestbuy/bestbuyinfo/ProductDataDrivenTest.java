package com.bestbuy.bestbuyinfo;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2X")
@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class ProductDataDrivenTest {
    private String name;
    private String type;
    private Integer price;
    private Integer upc;
    private String shipping;
    private String description;
    private String manufacturer;
    private String model;
    public String url;
    private String image;

    @Steps
    ProductSteps productSteps;
    @Title("Data driven test for creat multiple users to the application")
    @Test
    public void createUser() {
        productSteps.createProduct(name, type, price, upc, shipping, description, manufacturer, model, url, image).statusCode(201);
    }
}
