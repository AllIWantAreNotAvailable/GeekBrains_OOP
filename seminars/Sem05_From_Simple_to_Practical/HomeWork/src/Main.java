import Controllers.StudyGroupController;
import Model.Entities.Groups.StudyGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;
import View.StudyGroupView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        StudyGroupController controller = new StudyGroupController();
        StudyGroupView view = controller.getGroupView();

        GroupData data = initGroupData();
        view.createStudyGroup(data.students(), data.mentor());

    }

    private static GroupData initGroupData() {
        Random random = new Random();
        Teacher teacher = new Teacher(LocalDate.of(1975, 1, 9), "Maria", "Ivanova", Teacher.AcademicTitle.Docent);
        List<Student> students = Arrays.asList(
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Ivan", "Ivanov"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Petr", "Petrov"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Vasilii", "Pupkin"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Maksim", "Volkov"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Fedor", "Solovyev"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Alena", "Korobka"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Anna", "Pavlova"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Maryam", "Azbekova"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Pavel", "Glushko"),
                new Student(LocalDate.of(2023-18, random.nextInt(13), random.nextInt(28)), "Adam", "Gazaryan")
        );
        return new GroupData(teacher, students);
    }

    private record GroupData(Teacher mentor, List<Student> students) {
    }

}