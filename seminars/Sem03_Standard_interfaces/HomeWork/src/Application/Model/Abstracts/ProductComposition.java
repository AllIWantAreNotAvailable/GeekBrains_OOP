package Application.Model.Abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductComposition<T extends Product> implements Iterable<T>{
    protected List<T> composition;

    public ProductComposition(List<T> composition) {
        setComposition(composition);
    }

    public ProductComposition() {
        setComposition(new ArrayList<>());
    }

    public abstract List<T> getComposition();

    public abstract void setComposition(List<T> composition);

    public abstract void add(T ingredient);
}
