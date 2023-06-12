package Application.Model.Interfaces;

import Application.Model.Abstracts.Product;

public interface ProductsFactory {

    Product create(String name, Float volume, Float buyingPrice);

    Product create();

}
