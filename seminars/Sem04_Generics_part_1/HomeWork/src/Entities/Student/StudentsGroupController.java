package Entities.Student;

import java.util.Comparator;

public class StudentsGroupController {

    StudentsGroupService groupService;

    public StudentsGroupController(StudentsGroupService groupService) {
        setGroupService(groupService);
    }

    public StudentsGroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(StudentsGroupService groupService) {
        this.groupService = groupService;
    }

    public void delete(String firstName, String lastName) {
        getGroupService().deleteByFullName(firstName, lastName);
    }

    public void sort(Comparator<Student> comparator, boolean reversedOrder) {
        getGroupService().sortGroup(comparator, reversedOrder);
    }

    public void sort(Comparator<Student> comparator) {
        sort(comparator, false);
    }

}
