package Abstracts;

import Interfaces.UserGroupsStreamInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UserGroupsStream<T extends UsersGroup> implements UserGroupsStreamInterface<T>, Iterable<T> {

    static long nextUUID;

    protected long UUID;
    protected List<T> stream;

    public UserGroupsStream(List<T> stream) {
        setUUID(nextUUID++);
        setStream(stream);
    }

    public UserGroupsStream() {
        this(new ArrayList<>());
    }

    protected abstract void setUUID(long UUID);

    protected abstract void setStream(List<T> stream);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroupsStream<?> that)) return false;
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
