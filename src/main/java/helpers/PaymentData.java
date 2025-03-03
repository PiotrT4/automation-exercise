package helpers;

public class PaymentData {
    public final String nameOnCard;
    public final String cardNumber;
    public final String cvc;
    public final String expirationMonth;
    public final String expirationYear;

    public PaymentData(TestDataReader testDataReader) {
        this.nameOnCard = testDataReader.getNameOnCard();
        this.cardNumber = testDataReader.getCardNumber();
        this.cvc = testDataReader.getCvc();
        this.expirationMonth = testDataReader.getExpirationMonth();
        this.expirationYear = testDataReader.getExpirationYear();
    }
}
