package Model.Entities.Comparators.Default;

import Model.Abstracts.Base.Entity;
import Model.Abstracts.Base.EntitiesGroup;

import java.util.Comparator;

public class GroupComparator<T extends EntitiesGroup<? extends Entity>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getKeys().size(), o2.getKeys().size());
    }
}
