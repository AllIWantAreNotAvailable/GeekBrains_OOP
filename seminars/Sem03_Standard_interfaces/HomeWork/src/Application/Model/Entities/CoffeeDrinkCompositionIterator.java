package Application.Model.Entities;

import Application.Model.Abstracts.ProductCompositionIterator;
import Application.Model.Abstracts.ProductRaw;

public class CoffeeDrinkCompositionIterator extends ProductCompositionIterator<CoffeeDrinkComposition, ProductRaw> {
    public CoffeeDrinkCompositionIterator(CoffeeDrinkComposition productsStructure) {
        super(productsStructure);
    }
}
