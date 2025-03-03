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

    public Response createAccount() {
//        String requestBody =
//                "name=Jan" +
//                "&email=jan.kowalski@mail.com" +
//                "&password=test123" +
//                "&title=Mr" +
//                "&birth_date=15" +
//                "&birth_month=08" +
//                "&birth_year=1990" +
//                "&firstname=Adam" +
//                "&lastname=Kowalski" +
//                "&company=ExampleCorp" +
//                "&address1=Main+Street+123" +
//                "&address2=Apt+4B" +
//                "&country=Poland" +
//                "&zipcode=00-001" +
//                "&state=Mazowieckie" +
//                "&city=Warsaw" +
//                "&mobile_number=%2B48123456789";
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

        return response;
    }

    public Response deleteAccount() {
        String requestBody =
//                "email=jan.kowalski@mail.com" +
//                "&password=test123";
                "&email=" + personalData.email +
                "&password=" + personalData.password;

        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .body(requestBody)
                .delete("/deleteAccount");

        System.out.println("Response body: " + response.asString());

        return response;
    }


}
