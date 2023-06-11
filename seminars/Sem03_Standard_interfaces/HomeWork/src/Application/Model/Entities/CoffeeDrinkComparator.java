package Application.Model.Entities;

import Application.Model.Abstracts.ProductForSale;
import Application.Model.Abstracts.ProductForSaleComparator;

public class CoffeeDrinkComparator<T extends ProductForSale> extends ProductForSaleComparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int resultOfCompare = o1.getSellingPrice().compareTo(o2.getSellingPrice());
        if (resultOfCompare == 0) {
            resultOfCompare = o1.getBuyingPrice().compareTo(o2.getBuyingPrice());
            if (resultOfCompare == 0) {
                resultOfCompare = o1.getVolume().compareTo(o2.getVolume());
                if (resultOfCompare == 0) {
                    resultOfCompare = o1.getName().compareTo(o2.getName());
                }
            }
        }
        return resultOfCompare;
    }
}
