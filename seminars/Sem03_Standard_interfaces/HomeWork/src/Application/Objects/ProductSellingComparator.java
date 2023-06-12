package Application.Objects;

import Application.Enums.CoffeeAssortment;

import java.util.Comparator;

public class ProductSellingComparator implements Comparator<ProductSellingEntity> {
    @Override
    public int compare(ProductSellingEntity o1, ProductSellingEntity o2) {
        int resultOfCompare = o1.getAssortmentCode().compareTo((CoffeeAssortment) o2.getAssortmentCode());
        if (resultOfCompare == 0) return o1.compareTo(o2);
        else return resultOfCompare;
    }
}
