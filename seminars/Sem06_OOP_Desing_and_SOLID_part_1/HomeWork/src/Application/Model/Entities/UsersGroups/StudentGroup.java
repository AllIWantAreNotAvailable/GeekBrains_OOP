package Application.Model.Entities.UsersGroups;

import Application.Model.Abstract.Users.UsersGroupImpl;
import Application.Model.Entities.Users.Student;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentGroup extends UsersGroupImpl<Student> {

    private Student leader;

    public StudentGroup(Map<String, Student> group, Student leader) {
        super(group);
        setLeader(leader);
    }

    public StudentGroup(Map<String, Student> group) {
        super(group);
    }

    public StudentGroup(List<Student> group, Student leader) {
        super(group);
        setLeader(leader);
    }

    public StudentGroup(List<Student> group) {
        super(group);
    }

    public StudentGroup(Student leader) {
        super();
        setLeader(leader);
    }

    public StudentGroup() {
        super();
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        Objects.requireNonNull(leader);
        this.leader = Objects.requireNonNull(getStructure().get(leader.getUUID()),
                "A student must be a member of a group to become a student leader.");
    }

}
