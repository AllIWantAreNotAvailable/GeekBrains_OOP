package Model.Abstracts.Base;

import java.util.Iterator;
import java.util.List;

public abstract class EntityGroupIterator<T extends EntityGroup<E>, E extends Entity> implements Iterator<E> {
    protected int index;
    protected List<E> eList;

    public EntityGroupIterator(T tGroup) {
        this.index = 0;
        this.eList = tGroup.getValues();
    }

    protected abstract List<E> getList();
}
