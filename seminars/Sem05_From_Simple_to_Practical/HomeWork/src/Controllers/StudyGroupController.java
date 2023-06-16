package Controllers;

import Model.Entities.Groups.StudyGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;
import Model.Interfaces.Controllers.StudyGroupControllerInterface;
import Services.Groups.StudyGroupService;
import View.StudyGroupView;

import java.util.List;
import java.util.Objects;

public class StudyGroupController implements StudyGroupControllerInterface {

    private StudyGroupView groupView;
    private StudyGroupService groupService;

    public StudyGroupController(StudyGroupView groupView, StudyGroupService groupService) {
        setGroupView(groupView);
        setGroupService(groupService);
    }

    public StudyGroupController() {
        setGroupView(new StudyGroupView(this));
        setGroupService(new StudyGroupService());
    }

    public StudyGroupView getGroupView() {
        return groupView;
    }

    public void setGroupView(StudyGroupView groupView) {
        this.groupView = Objects.requireNonNull(groupView);
    }

    public StudyGroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(StudyGroupService groupService) {
        this.groupService = Objects.requireNonNull(groupService);
    }

    @Override
    public List<Student> getStudents() {
        return getGroupService().getValues();
    }

    @Override
    public List<Long> getStudentsUUIDs() {
        return getGroupService().getKeys();
    }

    @Override
    public Teacher getMentor() {
        return getGroupService().getMentor();
    }

    @Override
    public Long getTeachersUUID() {
        return getGroupService().getMentorsUUID();
    }

    @Override
    public StudyGroup createStudyGroup(List<Student> students, Teacher teacher) {
        return getGroupService().initStudyGroup(students, teacher);
    }
}
