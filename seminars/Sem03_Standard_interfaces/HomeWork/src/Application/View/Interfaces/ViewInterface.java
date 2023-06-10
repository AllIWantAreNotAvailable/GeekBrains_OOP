package Application.View.Interfaces;

public interface ViewInterface {

    void showMenu();

    void showProductPrice(String productName);

    void cashIn(Float cash);

    void cashOut();

    void getProduct(String productName, Float cash) throws Exception;

}
