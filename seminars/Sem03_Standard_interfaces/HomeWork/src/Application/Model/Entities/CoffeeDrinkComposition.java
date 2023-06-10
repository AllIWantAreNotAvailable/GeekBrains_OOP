package Application.Model.Entities;

import Application.Model.Abstracts.ProductComposition;
import Application.Model.Abstracts.ProductRaw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoffeeDrinkComposition extends ProductComposition<ProductRaw> {

    public CoffeeDrinkComposition(List<ProductRaw> composition) {
        super(composition);
    }

    public CoffeeDrinkComposition() {
        this(new ArrayList<>());
    }

    @Override
    public List<ProductRaw> getComposition() {
        return composition;
    }

    @Override
    public void setComposition(List<ProductRaw> composition) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (composition != null) {
            super.composition = composition;
        }
    }

    @Override
    public void add(ProductRaw ingredient) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (ingredient != null) {
            getComposition().add(ingredient);
        }
    }

    @Override
    public Iterator<ProductRaw> iterator() {
        return new CoffeeDrinkCompositionIterator(this);
    }
}
