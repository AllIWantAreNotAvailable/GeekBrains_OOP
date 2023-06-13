package Entities.Student;

import Abstracts.UsersGroup;

import java.util.*;


public class StudentsGroup extends UsersGroup<Student> {

    public StudentsGroup(List<Student> group) {
        super(group);
    }

    public StudentsGroup() {
        this(new ArrayList<>());
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void setGroup(List<Student> group) {
        super.group = Objects.requireNonNull(group);
    }

    @Override
    public long getUUID() {
        return super.UUID;
    }

    @Override
    public List<Student> getGroup() {
        return super.group;
    }

    @Override
    public boolean updateGroup(List<Student> group) {
        setGroup(Objects.requireNonNull(group));
        return true;
    }

    @Override
    public void add(Student student) {
        getGroup().add(student);
    }

    @Override
    public void add(List<Student> usersList) {
        for (Student student :
                usersList) {
            add(student);
        }
    }

    @Override
    public void sort(Comparator<Student> comparator) {
        getGroup().sort(comparator);
    }

    @Override
    public List<Student> sorted(Comparator<Student> comparator) {
        sort(comparator);
        return getGroup();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentsGroupIterator(this);
    }
}
