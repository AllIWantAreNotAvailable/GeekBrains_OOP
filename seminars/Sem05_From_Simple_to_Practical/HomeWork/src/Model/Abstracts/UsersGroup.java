package Model.Abstracts;

import Model.Entities.Student.Student;
import Model.Interfaces.UsersGroupInterface;

import java.util.*;

public abstract class UsersGroup<T extends User> implements UsersGroupInterface<T>, Iterable<T> {
    static long nextUUID;

    protected long UUID;
    protected Map<Long, T> group;

    public UsersGroup(Map<Long, T> group) {
        setUUID(nextUUID++);
        setGroup(group);
    }

    public UsersGroup(List<T> group) {
        this(new HashMap<>());
        setGroup(group);
    }

    public UsersGroup() {
        this(new HashMap<>());
    }

    protected abstract void setUUID(long UUID);

    protected abstract void setGroup(List<T> group);

    protected abstract void setGroup(Map<Long, T> structure);

    protected abstract Map<Long, T> getStructure();

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
