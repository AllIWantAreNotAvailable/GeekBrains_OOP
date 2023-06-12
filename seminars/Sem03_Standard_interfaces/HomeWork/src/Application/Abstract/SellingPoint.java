package Application.Abstract;

import Application.Interface.SellingPoints;
import Application.Interface.Vending;


public abstract class SellingPoint<T extends Enum<T>> implements SellingPoints<T> {
    protected Vending<T> productVending;
    protected Float cash;
    protected Float deposit;
    protected Float change;

    public SellingPoint(Vending<T> productVending) {
        setProductVending(productVending);
    }

    protected abstract void initLogic();
    public abstract void putPriceListRow(T article, Float price);

}
