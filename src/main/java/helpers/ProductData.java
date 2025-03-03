package helpers;

public class ProductData {
    private final String id;
    private String price;
    private String quantity;

    public ProductData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTotalPrice() {
        return String.valueOf(Integer.parseInt(getPrice()) * Integer.parseInt(getQuantity()));
    }

    public void setQuantity(String quantity) {
        if(!quantity.isEmpty()) this.quantity = quantity;
        else throw new RuntimeException("New quantity can not be empty!");
    }

    public void setPrice(String price) {
        if (!price.isEmpty()) this.price = price;
        else throw new RuntimeException("New price can not be empty!");
    }

}
