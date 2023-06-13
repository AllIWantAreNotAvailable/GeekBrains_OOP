package Model.Entities.Student;

import Model.Abstracts.UsersGroup;
import Model.Entities.Teacher.Teacher;

import java.util.*;


public class StudentsGroup extends UsersGroup<Student> {

    private Teacher curator;

    public StudentsGroup(List<Student> group, Teacher curator) {
        super(group);
        setCurator(curator);
    }

    public StudentsGroup(List<Student> group) {
        this(group, null);
    }

    public StudentsGroup() {
        super();
        setCurator(null);
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void setGroup(List<Student> group) {
        Objects.requireNonNull(group);
        for (Student student :
                group) {
            getStructure().put(student.getUUID(), student);
        }
    }

    @Override
    protected void setGroup(Map<Long, Student> structure) {
        super.group = Objects.requireNonNull(structure);
    }

    @Override
    protected Map<Long, Student> getStructure() {
        return super.group;
    }

    @Override
    public long getUUID() {
        return super.UUID;
    }

    @Override
    public List<Student> getGroup() {
        return new ArrayList<>(super.group.values());
    }

    @Override
    public boolean updateGroup(List<Student> group) {
        setGroup(Objects.requireNonNull(group));
        return true;
    }

    @Override
    public void add(Student user) {
        Objects.requireNonNull(user);
        getStructure().put(user.getUUID(), user);
    }

    @Override
    public void add(List<Student> usersList) {
        Objects.requireNonNull(usersList);
        for (Student student :
                usersList) {
            add(student);
        }
    }

    @Override
    public List<Student> sorted(Comparator<Student> comparator) {
        Objects.requireNonNull(comparator);
        List<Student> studentsList = getGroup();
        studentsList.sort(comparator);
        return studentsList;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentsGroupIterator(this);
    }
}
