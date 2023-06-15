package Model.Entities.Groups.Base;

import Model.Abstracts.EntitiesGroup;
import Model.Entities.Users.User;

import java.util.*;

public class UsersGroup<T extends User> extends EntitiesGroup<T> {

    public UsersGroup(Map<Long, T> group) {
        super(group);
    }

    public UsersGroup(List<T> group) {
        super(group);
    }

    public UsersGroup() {
        super();
    }

    @Override
    protected void initGroup(Map<Long, T> group) {
        this.group = Objects.requireNonNull(group);
    }

    @Override
    protected void initGroup(List<T> group) {
        initGroup();
        add(group);
    }

    @Override
    protected void initGroup() {
        initGroup(new HashMap<>());
    }

    @Override
    public Long getUUID() {
        return super.getUUID();
    }

    @Override
    public Map<Long, T> getStructure() {
        return super.group;
    }

    @Override
    public List<Long> getKeys() {
        return new ArrayList<>(getStructure().keySet());
    }

    @Override
    public List<T> getValues() {
        return new ArrayList<>(getStructure().values());
    }

    @Override
    public T getValue(Long UUID) {
        return Objects.requireNonNull(
                getStructure().get(
                        Objects.requireNonNull(UUID)
                )
        );
    }

    @Override
    public List<T> sorted(Comparator<T> comparator) {
        List<T> tList = getValues();
        tList.sort(Objects.requireNonNull(comparator));
        return tList;
    }

    @Override
    public void add(T value) {
        Objects.requireNonNull(value);
        getStructure().put(value.getUUID(), value);
    }

    @Override
    public void add(List<T> values) {
        for (T value :
                Objects.requireNonNull(values)) {
            add(value);
        }
    }

    @Override
    public T remove(Long UUID) {
        return getStructure().remove(
                Objects.requireNonNull(UUID)
        );
    }

    @Override
    public List<T> remove(List<Long> UUIDs) {
        List<T> tList = new ArrayList<>();
        for (Long uuid :
                Objects.requireNonNull(UUIDs)) {
            tList.add(remove(uuid));
        }
        return tList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersGroup<?> that)) return false;
        return Objects.equals(getStructure(), that.getStructure());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getStructure());
    }

    @Override
    public String toString() {
        return "UsersGroup{" +
                "UUID=" + getUUID() +
                ", users=" + getValues() +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new UserGroupIterator<>(this);
    }
}
