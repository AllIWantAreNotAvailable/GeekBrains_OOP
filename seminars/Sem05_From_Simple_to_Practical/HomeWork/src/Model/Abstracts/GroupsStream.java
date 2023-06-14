package Model.Abstracts;

import Model.Interfaces.GroupsStreamInterface;

import java.util.*;

public abstract class GroupsStream<T extends UsersGroup<? extends User>> extends Entity implements GroupsStreamInterface<T>, Iterable<T> {

    protected Map<Long, T> stream; // TODO: 14.06.2023 Заменить на HashMap<>(): ключ UserGroup.UUID; значение UserGroup

    public GroupsStream(Map<Long, T> stream) {
        super();
        initStream(stream);
    }

    public GroupsStream(List<T> stream) {
        this(new HashMap<>());
        setStream(stream);
    }

    public GroupsStream() {
        this(new HashMap<>());
    }

    protected abstract void initStream(Map<Long, T> stream);

    protected abstract void setStream(List<T> stream);

    protected abstract Map<Long, T> getStructure();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupsStream<?> that)) return false;
        return getUUID() == that.getUUID()
                && Objects.equals(getStream(), that.getStream());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getStream());
    }

    @Override
    public String toString() {
        return "UserGroupsStream{" +
                "UUID=" + getUUID() +
                ", stream=" + getStream() +
                '}';
    }
}
