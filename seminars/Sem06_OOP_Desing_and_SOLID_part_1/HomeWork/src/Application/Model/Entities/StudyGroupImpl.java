package Application.Model.Entities;

import Application.Model.Abstract.Base.Entity;
import Application.Model.Entities.Users.Student;
import Application.Model.Entities.Users.Teacher;
import Application.Model.Entities.UsersGroups.StudentGroup;
import Application.Model.Interfaces.StudyGroup;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupImpl extends Entity implements StudyGroup {

    private String SGUID;
    private StudentGroup studentGroup;
    private Teacher mentor;

    public StudyGroupImpl(String SGUID, Teacher mentor, StudentGroup studentGroup) {
        setSGUID(SGUID);
        setMentor(mentor);
        setStudentGroup(studentGroup);
    }

    private void setSGUID(String SGUID) {
        this.SGUID = SGUID;
    }

    public String getSGUID() {
        return SGUID;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Teacher getMentor() {
        return mentor;
    }

    public void setMentor(Teacher mentor) {
        this.mentor = mentor;
    }

    @Override
    public void add(List<Student> group) {
        getStudentGroup().add(group);
    }

    @Override
    public void add(Student user) {
        getStudentGroup().add(user);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(getStudentGroup().getStructure().values());
    }

    @Override
    public Student getStudentLeader() {
        return getStudentGroup().getLeader();
    }
}
