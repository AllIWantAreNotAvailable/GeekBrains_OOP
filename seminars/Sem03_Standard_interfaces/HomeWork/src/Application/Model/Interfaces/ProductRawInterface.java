package Application.Model.Interfaces;

import Application.Model.Abstracts.ProductRaw;

public interface ProductRawInterface {

    Float getRemainingVolume();

    ProductRaw splitProduct(Float amount) throws Exception;

    void refillProduct(ProductRaw product) throws Exception;

}
