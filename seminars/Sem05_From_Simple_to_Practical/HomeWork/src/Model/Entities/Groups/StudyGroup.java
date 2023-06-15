package Model.Entities.Groups;

import Model.Entities.Groups.Base.UsersGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudyGroup extends UsersGroup<Student> {

    private Teacher mentor;

    public StudyGroup(Map<Long, Student> group, Teacher mentor) {
        super(group);
        setMentor(mentor);
    }

    public StudyGroup(List<Student> group, Teacher mentor) {
        super(group);
        setMentor(mentor);
    }

    public StudyGroup(Teacher mentor) {
        super();
        setMentor(mentor);
    }

    public Teacher getMentor() {
        return mentor;
    }

    public void setMentor(Teacher mentor) {
        this.mentor = Objects.requireNonNull(mentor);
    }

    @Override
    public void add(Student student) {
        student.setStudyGroup(this);
        super.add(student);
    }

    @Override
    public Student remove(Long UUID) {
        getValue(UUID).setStudyGroup(null);
        return super.remove(UUID);
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (!(o instanceof StudyGroup students)) return false;
            return Objects.equals(getMentor(), students.getMentor());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMentor());
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "UUID=" + getUUID() +
                ", mentor=" + getMentor() +
                ", students=" + getValues() +
                '}';
    }


}
