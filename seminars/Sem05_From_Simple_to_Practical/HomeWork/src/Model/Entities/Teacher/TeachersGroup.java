package Model.Entities.Teacher;

import Model.Abstracts.UsersGroup;

import java.util.*;

public class TeachersGroup extends UsersGroup<Teacher> {

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
    protected void setGroup(List<Teacher> group) {
        Objects.requireNonNull(group);
        for (Teacher teacher :
                group) {
            getStructure().put(teacher.getUUID(), teacher);
        }
    }

    @Override
    protected void setGroup(Map<Long, Teacher> structure) {
        super.group = Objects.requireNonNull(structure);
    }

    @Override
    public long getUUID() {
        return super.UUID;
    }

    @Override
    public List<Teacher> getGroup() {
        return new ArrayList<>(super.group.values());
    }

    @Override
    protected Map<Long, Teacher> getStructure() {
        return super.group;
    }

    @Override
    public boolean updateGroup(List<Teacher> group) {
        setGroup(group);
        return true;
    }

    @Override
    public void add(Teacher user) {
        Objects.requireNonNull(user);
        getStructure().put(user.getUUID(), user);
    }

    @Override
    public void add(List<Teacher> usersList) {
        Objects.requireNonNull(usersList);
        for (Teacher teacher :
                usersList) {
            add(teacher);
        }
    }

    @Override
    public List<Teacher> sorted(Comparator<Teacher> comparator) {
        Objects.requireNonNull(comparator);
        List<Teacher> teachersList = getGroup();
        teachersList.sort(comparator);
        return teachersList;
    }

    @Override
    public Iterator<Teacher> iterator() {
        return new TeachersGroupIterator(this);
    }
}
