package Model.Entities.Factorys;

import Model.Entities.Student.StudentsGroup;
import Model.Interfaces.Factory;

import java.util.ArrayList;
import java.util.List;

public class StudentsGroupFactory implements Factory<StudentsGroup> {

    @Override
    public StudentsGroup create() {
        return new StudentsGroup();
    }

    @Override
    public List<StudentsGroup> createList(int quantity) {
        List<StudentsGroup> groupsList = new ArrayList<>();
        for (int i = 0; i < quantity; i++)
            groupsList.add(create());
        return groupsList;
    }

}
