package View;

import Controllers.StudyGroupController;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;
import Model.Interfaces.Views.StudyGroupViewInterface;

import java.util.List;

public class StudyGroupView implements StudyGroupViewInterface {
    
    private StudyGroupController controller;

    public StudyGroupView(StudyGroupController controller) {
        setController(controller);
    }

    public StudyGroupController getController() {
        return controller;
    }

    public void setController(StudyGroupController controller) {
        this.controller = controller;
    }

    private static String getString(List<?> list) {
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (Object student :
                list) {
            builder.append(String.format("%d) %s", ++counter, student)).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void getStudents() {
        List<Student> studentsList = getController().getStudents();
        System.out.println("Students journal:");
        String string = getString(studentsList);
        System.out.println(string);
    }

    @Override
    public void getStudentsUUIDs() {
        List<Long> studentsList = getController().getStudentsUUIDs();
        System.out.println("Students UUIDs:");
        String string = getString(studentsList);
        System.out.println(string.trim());
    }

    @Override
    public void getMentor() {
        Teacher mentor = getController().getMentor();
        System.out.println("Group mentor:");
        System.out.printf("- %s\n", mentor);
    }

    @Override
    public void getTeachersUUID() {
        Long mentorsUUID = getController().getTeachersUUID();
        System.out.println("Mentors UUID:");
        System.out.printf("- %d", mentorsUUID);
    }

    @Override
    public void createStudyGroup(List<Student> students, Teacher teacher) {
        getController().createStudyGroup(students, teacher);
        System.out.println("Study group:");
        System.out.printf("+ ");
        getMentor();
        System.out.printf("+ ");
        getStudents();
    }
}
