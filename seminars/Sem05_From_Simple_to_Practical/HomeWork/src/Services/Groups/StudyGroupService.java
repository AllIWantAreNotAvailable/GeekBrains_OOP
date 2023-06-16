package Services.Groups;

import Model.Entities.Groups.StudyGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;
import Services.Abstracts.GroupService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudyGroupService extends GroupService<StudyGroup, Student> {

    public StudyGroupService(StudyGroup group) {
        super(group);
    }

    public StudyGroupService() {
        super();
    }

    public StudyGroup initStudyGroup(List<Student> students, Teacher teacher) {
        setGroup(new StudyGroup(students, teacher));
        return getGroup();
    }

    @Override
    public StudyGroup getGroup() {
        return super.group;
    }

    @Override
    public void setGroup(StudyGroup group) {
        super.group = Objects.requireNonNull(group);
    }

    public Teacher getMentor() {
        return getGroup().getMentor();
    }

    public Long getMentorsUUID() {
        return getMentor().getUUID();
    }

    public void setMentor(Teacher mentor) {
        getGroup().setMentor(mentor);
    }

    @Override
    public Map<Long, Student> getStructure() {
        return getGroup().getStructure();
    }

    @Override
    public List<Long> getKeys() {
        return getGroup().getKeys();
    }

    @Override
    public List<Student> getValues() {
        return getGroup().getValues();
    }

    @Override
    public Student getValue(Long UUID) {
        return getGroup().getValue(UUID);
    }

    @Override
    public List<Student> sorted(Comparator<Student> comparator) {
        return getGroup().sorted(comparator);
    }

    @Override
    public void add(Student value) {
        getGroup().add(value);
    }

    @Override
    public void add(List<Student> values) {
        getGroup().add(values);
    }

    @Override
    public Student remove(Long UUID) {
        return getGroup().remove(UUID);
    }

    @Override
    public List<Student> remove(List<Long> UUIDs) {
        return getGroup().remove(UUIDs);
    }
}
