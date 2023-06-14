package Model.Entities.Comparators.Default;

import Model.Abstracts.Base.Entity;

import java.util.Comparator;

public class EntityComparator<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getUUID().compareTo(o2.getUUID());
    }
}
