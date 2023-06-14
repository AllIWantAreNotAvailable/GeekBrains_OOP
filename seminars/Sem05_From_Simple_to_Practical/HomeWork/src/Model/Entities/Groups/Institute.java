package Model.Entities.Groups;

import Model.Abstracts.Base.EntitiesGroup;
import Model.Entities.Teacher.TeachersGroup;

import java.util.*;

public class Institute extends EntitiesGroup<TeachersGroup> {

    public Institute(Map<Long, TeachersGroup> group) {
        super(group);
    }

    public Institute(List<TeachersGroup> group) {
        super(group);
    }

    public Institute() {
        super();
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    public Long getUUID() {
        return UUID;
    }

    @Override
    protected void initGroup(Map<Long, TeachersGroup> group) {
        super.group = Objects.requireNonNull(group, "The field cannot be Null");
    }

    @Override
    protected void initGroup(List<TeachersGroup> group) {
        initGroup();
        add(group);
    }

    @Override
    protected void initGroup() {
        initGroup(new HashMap<>());
    }

    @Override
    public Map<Long, TeachersGroup> getStructure() {
        return super.group;
    }

    @Override
    public List<Long> getKeys() {
        return new ArrayList<>(getStructure().keySet());
    }

    @Override
    public List<TeachersGroup> getValues() {
        return new ArrayList<>(getStructure().values());
    }

    @Override
    public TeachersGroup getValue(Long UUID) {
        return Objects.requireNonNull(
                getStructure().get(
                        Objects.requireNonNull(UUID, "The field cannot be Null")
                )
        );
    }

    @Override
    public List<TeachersGroup> sorted(Comparator<TeachersGroup> comparator) {
        List<TeachersGroup> list = getValues();
        list.sort(comparator);
        return list;
    }

    @Override
    public void add(TeachersGroup value) {
        Objects.requireNonNull(value, "The field cannot be Null");
        getStructure().put(value.getUUID(), value);
    }

    @Override
    public void add(List<TeachersGroup> values) {
        for (TeachersGroup teachersGroup :
                Objects.requireNonNull(values, "The field cannot be Null")) {
            add(teachersGroup);
        }
    }

    @Override
    public void remove(Long UUID) {
        getStructure().remove(Objects.requireNonNull(UUID, "The field cannot be Null"));
    }

    @Override
    public void remove(List<Long> UUIDs) {
        for (Long uuid :
                Objects.requireNonNull(UUIDs, "The field cannot be Null")) {
            remove(uuid);
        }
    }

    @Override
    public String toString() {
        return "Institute{" +
                "UUID=" + getUUID() +
                ", values=" + getValues() +
                '}';
    }

    @Override
    public Iterator<TeachersGroup> iterator() {
        return new InstituteIterator(this);
    }
}
