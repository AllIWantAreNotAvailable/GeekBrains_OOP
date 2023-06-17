package Application.Model.Entities.UsersGroups;

import Application.Model.Abstract.Users.UsersGroupImpl;
import Application.Model.Entities.Users.Teacher;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TeachersGroup extends UsersGroupImpl<Teacher> {

    private Teacher facultyHead;

    public TeachersGroup(Map<String, Teacher> group, Teacher facultyHead) {
        super(group);
        setFacultyHead(facultyHead);
    }

    public TeachersGroup(Map<String, Teacher> group) {
        super(group);
    }

    public TeachersGroup(List<Teacher> group, Teacher facultyHead) {
        super(group);
        setFacultyHead(facultyHead);
    }

    public TeachersGroup(List<Teacher> group) {
        super(group);
    }

    public TeachersGroup(Teacher facultyHead) {
        super();
        setFacultyHead(facultyHead);
    }

    public TeachersGroup() {
        super();
    }

    public Teacher getFacultyHead() {
        return facultyHead;
    }

    public void setFacultyHead(Teacher facultyHead) {
        Objects.requireNonNull(facultyHead);
        this.facultyHead = Objects.requireNonNull(getStructure().get(facultyHead.getUUID()),
                "A Teacher must be a member of a group to become a department leader.");
    }
}
