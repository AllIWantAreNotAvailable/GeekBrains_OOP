package Application.Interface;

import Application.Abstract.Product;

public interface Vending<E> {

    Products create(E arg) throws Exception;
}
