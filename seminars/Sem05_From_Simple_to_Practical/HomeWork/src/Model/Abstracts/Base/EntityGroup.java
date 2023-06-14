package Model.Abstracts.Base;

import Model.Interfaces.Base.EntityGroupInterface;

import java.util.List;
import java.util.Map;

public abstract class EntityGroup<T extends Entity> extends Entity implements EntityGroupInterface<T>, Iterable<T> {

    protected Map<Long, T> group;

    public EntityGroup(Map<Long, T> group) {
        initGroup(group);
    }

    public EntityGroup(List<T> group) {
        initGroup(group);
    }

    public EntityGroup() {
        initGroup();
    }

    protected abstract void initGroup(Map<Long, T> group);

    protected abstract void initGroup(List<T> group);

    protected abstract void initGroup();
}
