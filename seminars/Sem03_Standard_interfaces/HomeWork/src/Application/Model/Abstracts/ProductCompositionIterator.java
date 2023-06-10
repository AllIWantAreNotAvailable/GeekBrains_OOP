package Application.Model.Abstracts;

import java.util.Iterator;
import java.util.List;

public abstract class ProductCompositionIterator<E extends ProductComposition<T>, T extends Product> implements Iterator<T> {

    protected int nextIndex;
    protected List<T> productsList;

    public ProductCompositionIterator(E productsStructure) {
        setProductsList(productsStructure);
        this.nextIndex = 0;
    }

    protected void setProductsList(E productsStructure) {
        this.productsList = productsStructure.getComposition();
    }

    @Override
    public boolean hasNext() {
        return nextIndex < productsList.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return productsList.get(nextIndex++);
        }
        throw new RuntimeException("Iterator throw NullPointerException");
    }

}
