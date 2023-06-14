package Model.Entities.Student;

import Model.Abstracts.Base.EntityGroup;
import Model.Entities.Teacher.Teacher;

import java.util.*;

public class StudentsGroup extends EntityGroup<Student> {

    public StudentsGroup(Map<Long, Student> group) {
        super(group);
    }

    public StudentsGroup(List<Student> group) {
        super(group);
    }

    public StudentsGroup() {
        super();
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void initGroup(Map<Long, Student> group) {
        super.group = Objects.requireNonNull(group, "The field cannot be Null");
    }

    @Override
    protected void initGroup(List<Student> group) {
        initGroup();
        add(group);
    }

    @Override
    protected void initGroup() {
        initGroup(new HashMap<>());
    }

    @Override
    public Map<Long, Student> getStructure() {
        return super.group;
    }

    @Override
    public List<Long> getKeys() {
        return new ArrayList<>(getStructure().keySet());
    }

    @Override
    public List<Student> getValues() {
        return new ArrayList<>(getStructure().values());
    }

    @Override
    public Student getValue(Long UUID) {
        return Objects.requireNonNull(
                getStructure().get(
                        Objects.requireNonNull(UUID, "The field cannot be Null")
                )
        );
    }

    @Override
    public List<Student> sorted(Comparator<Student> comparator) {
        List<Student> list = getValues();
        list.sort(comparator);
        return list;
    }

    @Override
    public void add(Student value) {
        Objects.requireNonNull(value, "The field cannot be Null");
        getStructure().put(value.getUUID(), value);
    }

    @Override
    public void add(List<Student> values) {
        for (Student student :
                Objects.requireNonNull(values, "The field cannot be Null")) {
            add(student);
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
        return "StudentsGroup{" +
                ", values=" + getValues() +
                '}';
    }

    @Override
    public Iterator<Student> iterator() {
        return null;
    }
}
