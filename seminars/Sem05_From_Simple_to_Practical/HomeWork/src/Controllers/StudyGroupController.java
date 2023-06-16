package Controllers;

import Model.Entities.Groups.StudyGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;
import Services.Groups.StudyGroupService;

import java.util.List;

public class StudyGroupController {

    private StudyGroupService groupService;

    public StudyGroupController(StudyGroupService groupService) {
        setGroupService(groupService);
    }

    public StudyGroupController() {
        setGroupService(new StudyGroupService());
    }

    public StudyGroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(StudyGroupService groupService) {
        this.groupService = groupService;
    }

    public List<Student> getStudents() {
        return getGroupService().getValues();
    }

    public List<Long> getStudentsUUIDs() {
        return getGroupService().getKeys();
    }

    public Teacher getMentor() {
        return getGroupService().getMentor();
    }

    public Long getTeachersUUID() {
        return getGroupService().getMentorsUUID();
    }

    public StudyGroup createStudyGroup(List<Student> students, Teacher teacher) {
        return getGroupService().initStudyGroup(students, teacher);
    }
}
