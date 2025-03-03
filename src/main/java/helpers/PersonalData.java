package helpers;

public class PersonalData {
    public final String email;
    public final String password;
    public final boolean newsletter;
    public final boolean specialOffers;
    public final String title;
    public final String firstName;
    public final String lastName;
    public final String address;
    public final String country;
    public final String state;
    public final String city;
    public final String zipCode;
    public final String mobileNumber;
    public final String searchProduct;
    public final String subject;
    public final String message;
    public final String uploadFilePath;
    public final String incorrectPassword;

    public PersonalData(TestDataReader testDataReader) {
        this.email = testDataReader.getEmail();
        this.password = testDataReader.getPassword();
        this.newsletter = testDataReader.isNewsletter();
        this.specialOffers = testDataReader.isSpecialOffers();
        this.title = testDataReader.getTitle();
        this.firstName = testDataReader.getFirstName();
        this.lastName = testDataReader.getLastName();
        this.address = testDataReader.getAddress();
        this.country = testDataReader.getCountry();
        this.state = testDataReader.getState();
        this.city = testDataReader.getCity();
        this.zipCode = testDataReader.getZipCode();
        this.mobileNumber = testDataReader.getMobileNumber();
        this.searchProduct = testDataReader.getSearchProduct();
        this.subject = testDataReader.getSubject();
        this.message = testDataReader.getMessage();
        this.uploadFilePath = testDataReader.getUploadFilePath();
        this.incorrectPassword = testDataReader.getIncorrectPassword();
    }

}
