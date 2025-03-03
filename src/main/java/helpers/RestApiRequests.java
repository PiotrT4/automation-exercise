package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestApiRequests {

    private static final String baseUrl = "https://automationexercise.com/api";
    private final PersonalData personalData;

    public RestApiRequests() {
        RestAssured.baseURI = baseUrl;
        personalData = new PersonalData(new TestDataReader());
    }

    public void createAccount() {
        String requestBody =
                "name=" + personalData.firstName +
                "&email=" + personalData.email +
                "&password=" + personalData.password +
                "&title=" + personalData.title +
                "&firstname=" + personalData.firstName +
                "&lastname=" + personalData.lastName +
                "&address1=" + personalData.address +
                "&country=" + personalData.country +
                "&zipcode=" + personalData.zipCode +
                "&state=" + personalData.state +
                "&city=" + personalData.city +
                "&mobile_number=" + personalData.mobileNumber;

        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .body(requestBody)
                .post("/createAccount");

        System.out.println("Response body: " + response.asString());
    }

    public void deleteAccount() {
        String requestBody =
                "&email=" + personalData.email +
                "&password=" + personalData.password;

        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .body(requestBody)
                .delete("/deleteAccount");

        System.out.println("Response body: " + response.asString());
    }


}
