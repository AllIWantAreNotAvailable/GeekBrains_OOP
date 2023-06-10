package Application.Services.Interfaces;

import Application.Model.Abstracts.Product;

import java.util.Map;

public interface ProductServiceInterface {

    Map<String, Float> getPriceList();

    Float getProductPrice(String productName);

    void makeDeposit(Float cash);

    void makeOrder(String productName) throws Exception;

    Float getChange();

    Product buyProduct(String productName, Float cash) throws Exception;
}
