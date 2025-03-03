package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    private final String email;
    private final String password;
    private final String newsletter;
    private final String specialOffers;
    private final String title;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String country;
    private final String state;
    private final String city;
    private final String zipCode;
    private final String mobileNumber;
    private final String searchProduct;
    private final String subject;
    private final String message;
    private final String uploadFilePath;
    private final String product1Id;
    private final String product2Id;
    private final String product3Id;
    private final String incorrectPassword;
    private final String nameOnCard;
    private final String cardNumber;
    private final String cvc;
    private final String expirationMonth;
    private final String expirationYear;

    public TestDataReader() {
        String configurationPath = "src/main/resources/testData.properties";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(configurationPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found: " + configurationPath);
        }

        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        email = properties.getProperty("email");
        password = properties.getProperty("password");
        newsletter = properties.getProperty("newsletter");
        specialOffers = properties.getProperty("specialOffers");
        title = properties.getProperty("title");
        firstName = properties.getProperty("firstName");
        lastName = properties.getProperty("lastName");
        address = properties.getProperty("address");
        country = properties.getProperty("country");
        state = properties.getProperty("state");
        city = properties.getProperty("city");
        zipCode = properties.getProperty("zipCode");
        mobileNumber = properties.getProperty("mobileNumber");
        searchProduct = properties.getProperty("searchProduct");
        subject = properties.getProperty("subject");
        message = properties.getProperty("message");
        uploadFilePath = properties.getProperty("uploadFilePath");
        product1Id = properties.getProperty("product1Id");
        product2Id = properties.getProperty("product2Id");
        product3Id = properties.getProperty("product3Id");
        incorrectPassword = properties.getProperty("incorrectPassword");
        nameOnCard = properties.getProperty("nameOnCard");
        cardNumber = properties.getProperty("cardNumber");
        cvc = properties.getProperty("cvc");
        expirationMonth = properties.getProperty("expirationMonth");
        expirationYear = properties.getProperty("expirationYear");
    }

    public String getEmail() {
        if (!email.isEmpty()) return email;
        else throw new RuntimeException("\"email\" is not specified in the testData.properties file");
    }

    public String getPassword() {
        if (!password.isEmpty()) return password;
        else throw new RuntimeException("\"password\" is not specified in the testData.properties file");
    }

    public boolean isNewsletter() {
        if (!newsletter.isEmpty()) return Boolean.parseBoolean(newsletter);
        else throw new RuntimeException("\"newsletter\" is not specified in the testData.properties file");
    }

    public boolean isSpecialOffers() {
        if (!specialOffers.isEmpty()) return Boolean.parseBoolean(specialOffers);
        else throw new RuntimeException("\"specialOffers\" is not specified in the testData.properties file");
    }

    public String getTitle() {
        if (!title.isEmpty()) return title;
        else throw new RuntimeException("\"title\" is not specified in the testData.properties file");
    }

    public String getFirstName() {
        if (!firstName.isEmpty()) return firstName;
        else throw new RuntimeException("\"firstName\" is not specified in the testData.properties file");
    }

    public String getLastName() {
        if (!lastName.isEmpty()) return lastName;
        else throw new RuntimeException("\"lastName\" is not specified in the testData.properties file");
    }

    public String getAddress() {
        if (!address.isEmpty()) return address;
        else throw new RuntimeException("\"address\" is not specified in the testData.properties file");
    }

    public String getCountry() {
        if (!country.isEmpty()) return country;
        else throw new RuntimeException("\"country\" is not specified in the testData.properties file");
    }

    public String getState() {
        if (!state.isEmpty()) return state;
        else throw new RuntimeException("\"state\" is not specified in the testData.properties file");
    }

    public String getCity() {
        if (!city.isEmpty()) return city;
        else throw new RuntimeException("\"city\" is not specified in the testData.properties file");
    }

    public String getZipCode() {
        if (!zipCode.isEmpty()) return zipCode;
        else throw new RuntimeException("\"zipCode\" is not specified in the testData.properties file");
    }

    public String getMobileNumber() {
        if (!mobileNumber.isEmpty()) return mobileNumber;
        else throw new RuntimeException("\"mobileNumber\" is not specified in the testData.properties file");
    }

    public String getSearchProduct() {
        if (!searchProduct.isEmpty()) return searchProduct;
        else throw new RuntimeException("\"searchProduct\" is not specified in the testData.properties file");
    }

    public String getSubject() {
        if (!subject.isEmpty()) return subject;
        else throw new RuntimeException("\"subject\" is not specified in the testData.properties file");
    }

    public String getMessage() {
        if (!message.isEmpty()) return message;
        else throw new RuntimeException("\"message\" is not specified in the testData.properties file");
    }

    public String getUploadFilePath() {
        if (!uploadFilePath.isEmpty()) return uploadFilePath;
        else throw new RuntimeException("\"uploadFilePath\" is not specified in the testData.properties file");
    }

    public String getProduct1Id() {
        if (!product1Id.isEmpty()) return product1Id;
        else throw new RuntimeException("\"product1Id\" is not specified in the testData.properties file");
    }

    public String getProduct2Id() {
        if (!product2Id.isEmpty()) return product2Id;
        else throw new RuntimeException("\"product2Id\" is not specified in the testData.properties file");
    }

    public String getProduct3Id() {
        if (!product3Id.isEmpty()) return product3Id;
        else throw new RuntimeException("\"product3Id\" is not specified in the testData.properties file");
    }

    public String getIncorrectPassword() {
        if (!incorrectPassword.isEmpty()) return incorrectPassword;
        else throw new RuntimeException("\"product3Id\" is not specified in the testData.properties file");
    }

    public String getExpirationYear() {
        if (!expirationYear.isEmpty()) return expirationYear;
        else throw new RuntimeException("\"expirationYear\" is not specified in the testData.properties file");
    }

    public String getExpirationMonth() {
        if (!expirationMonth.isEmpty()) return expirationMonth;
        else throw new RuntimeException("\"expirationMonth\" is not specified in the testData.properties file");
    }

    public String getCvc() {
        if (!cvc.isEmpty()) return cvc;
        else throw new RuntimeException("\"cvc\" is not specified in the testData.properties file");
    }

    public String getCardNumber() {
        if (!cardNumber.isEmpty()) return cardNumber;
        else throw new RuntimeException("\"cardNumber\" is not specified in the testData.properties file");
    }

    public String getNameOnCard() {
        if (!nameOnCard.isEmpty()) return nameOnCard;
        else throw new RuntimeException("\"nameOnCard\" is not specified in the testData.properties file");
    }
}
