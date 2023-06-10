package Application.Services.Interface;

import Application.Model.Abstracts.Product;

public interface ProductServiceInterface {

    Float getProductPrice(String productName);

    void makeDeposit(Float cash);

    void makeOrder(String productName) throws Exception;

    Float getChange();

    Product buyProduct(String productName, Float cash) throws Exception;
}
