package Model.Abstracts.Base;

import Model.Interfaces.Base.EntityGroupInterface;

import java.util.List;
import java.util.Map;

public abstract class EntitiesGroup<T extends Entity> extends Entity implements EntityGroupInterface<T>, Iterable<T> {

    protected Map<Long, T> group;

    public EntitiesGroup(Map<Long, T> group) {
        initGroup(group);
    }

    public EntitiesGroup(List<T> group) {
        initGroup(group);
    }

    public EntitiesGroup() {
        initGroup();
    }

    protected abstract void initGroup(Map<Long, T> group);

    protected abstract void initGroup(List<T> group);

    protected abstract void initGroup();
}
