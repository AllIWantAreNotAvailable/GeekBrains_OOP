package Model.Entities.Teacher;

import Model.Abstracts.Users.UsersGroup;

import java.util.*;

public class TeachersGroup extends UsersGroup<Teacher> {

    public TeachersGroup(Map<Long, Teacher> group) {
        super(group);
    }

    public TeachersGroup(List<Teacher> group) {
        super(group);
    }

    public TeachersGroup() {
        super();
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void initGroup(Map<Long, Teacher> group) {
        super.group = Objects.requireNonNull(group, "The field cannot be Null");
    }

    @Override
    protected void initGroup(List<Teacher> group) {
        initGroup();
        add(group);
    }

    @Override
    protected void initGroup() {
        initGroup(new HashMap<>());
    }

    @Override
    public Map<Long, Teacher> getStructure() {
        return super.group;
    }

    @Override
    public List<Long> getKeys() {
        return new ArrayList<>(getStructure().keySet());
    }

    @Override
    public List<Teacher> getValues() {
        return new ArrayList<>(getStructure().values());
    }

    @Override
    public Teacher getValue(Long UUID) {
        return Objects.requireNonNull(
                getStructure().get(
                        Objects.requireNonNull(UUID, "The field cannot be Null")
                )
        );
    }

    @Override
    public List<Teacher> sorted(Comparator<Teacher> comparator) {
        List<Teacher> list = getValues();
        list.sort(comparator);
        return list;
    }

    @Override
    public void add(Teacher value) {
        Objects.requireNonNull(value, "The field cannot be Null");
        getStructure().put(value.getUUID(), value);
    }

    @Override
    public void add(List<Teacher> values) {
        for (Teacher teacher :
                Objects.requireNonNull(values, "The field cannot be Null")) {
            add(teacher);
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
        return "TeachersGroup{" +
                "values=" + getValues() +
                '}';
    }

    @Override
    public Iterator<Teacher> iterator() {
        return new TeachersGroupIterator(this);
    }
}
