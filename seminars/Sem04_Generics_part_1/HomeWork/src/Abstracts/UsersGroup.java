package Abstracts;

import Interfaces.UsersGroupInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UsersGroup<T extends User> implements UsersGroupInterface<T>, Iterable<T> {
    static long nextUUID;

    protected long UUID;
    protected List<T> group;

    public UsersGroup(List<T> group) {
        setUUID(nextUUID++);
        setGroup(group);
    }

    public UsersGroup() {
        this(new ArrayList<>());
    }

    protected abstract void setUUID(long UUID);

    protected abstract void setGroup(List<T> group);

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof UsersGroup<?> that)) return false;
        return getUUID() == that.getUUID()
                && Objects.equals(getGroup(), that.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getGroup());
    }

    @Override
    public String toString() {
        return "UsersGroup{" +
                "UUID=" + getUUID() +
                ", group=" + getGroup() +
                '}';
    }
}
