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
        super.composition = composition;
    }

    @Override
    public void add(ProductRaw ingredient) {
        getComposition().add(ingredient);
    }

    @Override
    public Iterator<ProductRaw> iterator() {
        return new CoffeeDrinkCompositionIterator(this);
    }

    @Override
    public String toString() {
        String out = getComposition().toString();
        return "CoffeeDrinkComposition{"
                + out.substring(1, out.length() - 1) +
                '}';
    }
}
