package Application.Interface;

public interface SellingPoints<T extends Enum<T>> {
    Vending<T> getProductVending();

    void setProductVending(Vending<T> productVending);

    Float getCash();

    void setCash(Float cash);

    void makeDeposit(Float cash);

    Products buyProduct(T arg) throws Exception;

    Float getChange();

    Float getProductPrice(T arg);
}
