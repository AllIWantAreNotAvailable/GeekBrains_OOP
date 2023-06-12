package Entities.Teacher;

import Abstracts.UsersGroup;

import java.util.*;

public class TeachersGroup extends UsersGroup<Teacher> {

    public TeachersGroup(List<Teacher> group) {
        super(group);
    }

    public TeachersGroup() {
        this(new ArrayList<>());
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void setGroup(List<Teacher> group) {
        super.group = Objects.requireNonNull(group);
    }

    @Override
    public long getUUID() {
        return super.UUID;
    }

    @Override
    public List<Teacher> getGroup() {
        return super.group;
    }

    @Override
    public boolean updateGroup(List<Teacher> group) {
        setGroup(group);
        return true;
    }

    @Override
    public void add(Teacher user) {
        getGroup().add(Objects.requireNonNull(user));
    }

    @Override
    public void add(List<Teacher> usersList) {
        for (Teacher teacher :
                usersList) {
            add(teacher);
        }
    }

    @Override
    public void sort(Comparator<Teacher> comparator) {
        getGroup().sort(comparator);
    }

    @Override
    public List<Teacher> sorted(Comparator<Teacher> comparator) {
        sort(comparator);
        return getGroup();
    }

    @Override
    public Iterator<Teacher> iterator() {
        return new TeachersGroupIterator(this);
    }
}
