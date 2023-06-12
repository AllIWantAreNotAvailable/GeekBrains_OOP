package Application.Objects;

import Application.Abstract.Product;
import Application.Abstract.SellingPoint;
import Application.Enums.CoffeeAssortment;
import Application.Interface.Products;
import Application.Interface.Vending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoffeeSellingPoint extends SellingPoint<CoffeeAssortment> {

    public CoffeeSellingPoint(Vending<CoffeeAssortment> productVending) {
        super(productVending);
    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void putPriceListRow(CoffeeAssortment article, Float price) {

    }

    @Override
    public Vending<CoffeeAssortment> getProductVending() {
        return null;
    }

    @Override
    public void setProductVending(Vending<CoffeeAssortment> productVending) {

    }

    @Override
    public Float getCash() {
        return null;
    }

    @Override
    public void setCash(Float cash) {

    }

    @Override
    public void makeDeposit(Float cash) {

    }

    @Override
    public Products buyProduct(CoffeeAssortment arg) throws Exception {
        getProductVending().create(arg);
        return null;
    }

    @Override
    public Float getChange() {
        return null;
    }

    @Override
    public Float getProductPrice(CoffeeAssortment arg) {
        return null;
    }
}
