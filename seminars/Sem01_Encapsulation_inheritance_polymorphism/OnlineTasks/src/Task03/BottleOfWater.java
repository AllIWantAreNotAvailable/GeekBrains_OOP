package Task03;

public class BottleOfWater extends Product {
    public BottleOfWater(String productName, float price) {
        super.productName = productName;
        super.price = price;
    }

    @Override
    public String getProductName() {
        return super.productName;
    }

    @Override
    public Float getPrice() {
        return super.price;
    }

    @Override
    public String toString() {
        return "BottleOfWater" +
                "productName='" + super.productName + '\'' +
                ", price=" + super.price +
                '}';
    }
}
