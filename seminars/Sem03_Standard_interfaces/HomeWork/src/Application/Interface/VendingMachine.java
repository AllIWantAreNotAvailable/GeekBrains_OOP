package Application.Interface;

import Application.Abstract.AbsProduct;

import java.util.List;

public interface VendingMachine<T extends AbsProduct> {
    boolean isWorking();
    void powerOn();
    void powerOff();
    void putProduct(T product);
    void putProduct(List<T> products);
    T getProduct(String name);
}
