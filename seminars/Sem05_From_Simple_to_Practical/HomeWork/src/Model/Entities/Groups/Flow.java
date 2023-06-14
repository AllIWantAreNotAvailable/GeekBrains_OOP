package Model.Entities.Groups;

import Model.Abstracts.Base.EntitiesGroup;
import Model.Entities.Student.StudentsGroup;

import java.util.*;

public class Flow extends EntitiesGroup<StudentsGroup> {
    public Flow(Map<Long, StudentsGroup> group) {
        super(group);
    }

    public Flow(List<StudentsGroup> group) {
        super(group);
    }

    public Flow() {
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
    protected void initGroup(Map<Long, StudentsGroup> group) {
        super.group = Objects.requireNonNull(group, "The field cannot be Null");
    }

    @Override
    protected void initGroup(List<StudentsGroup> group) {
        initGroup();
        add(group);
    }

    @Override
    protected void initGroup() {
        initGroup(new HashMap<>());
    }

    @Override
    public Map<Long, StudentsGroup> getStructure() {
        return super.group;
    }

    @Override
    public List<Long> getKeys() {
        return new ArrayList<>(getStructure().keySet());
    }

    @Override
    public List<StudentsGroup> getValues() {
        return new ArrayList<>(getStructure().values());
    }

    @Override
    public StudentsGroup getValue(Long UUID) {
        return Objects.requireNonNull(
                getStructure().get(
                        Objects.requireNonNull(UUID, "The field cannot be Null")
                )
        );
    }

    @Override
    public List<StudentsGroup> sorted(Comparator<StudentsGroup> comparator) {
        List<StudentsGroup> list = getValues();
        list.sort(comparator);
        return list;
    }

    @Override
    public void add(StudentsGroup value) {
        Objects.requireNonNull(value, "The field cannot be Null");
        getStructure().put(value.getUUID(), value);
    }

    @Override
    public void add(List<StudentsGroup> values) {
        for (StudentsGroup studentsGroup :
                Objects.requireNonNull(values, "The field cannot be Null")) {
            add(studentsGroup);
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
        return "Flow{" +
                "UUID=" + getUUID() +
                ", values=" + getValues() +
                '}';
    }

    @Override
    public Iterator<StudentsGroup> iterator() {
        return new FlowIterator(this);
    }
}
