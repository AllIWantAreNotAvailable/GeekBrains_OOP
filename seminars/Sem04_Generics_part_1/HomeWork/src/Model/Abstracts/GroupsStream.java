package Model.Abstracts;

import Model.Interfaces.GroupsStreamInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class GroupsStream<T extends UsersGroup<? extends User>> implements GroupsStreamInterface<T>, Iterable<T> {

    static long nextUUID;

    protected long UUID;
    protected List<T> stream; // TODO: 14.06.2023 Заменить на HashMap<>(): ключ UserGroup.UUID; значение UserGroup

    public GroupsStream(List<T> stream) {
        setUUID(nextUUID++);
        setStream(stream);
    }

    public GroupsStream() {
        this(new ArrayList<>());
    }

    protected abstract void setUUID(long UUID);

    protected abstract void setStream(List<T> stream);

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
