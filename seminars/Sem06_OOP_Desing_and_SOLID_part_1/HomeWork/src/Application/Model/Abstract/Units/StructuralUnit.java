package Application.Model.Abstract.Units;

import Application.Model.Abstract.Base.Entity;
import Application.Model.Abstract.Base.EntitiesGroup;
import Application.Model.Abstract.Users.UsersGroupImpl;
import Application.Model.Abstract.Users.UserImpl;

import java.util.Map;

public abstract class StructuralUnit<T extends Entity, E extends UsersGroupImpl<U>, U extends UserImpl> extends EntitiesGroup {

    Map<String, T> unit;
    E department;

    public StructuralUnit(Map<String, T> unit, E department) {
        setUnit(unit);
        setDepartment(department);
    }

    public Map<String, T> getUnit() {
        return unit;
    }

    public void setUnit(Map<String, T> unit) {
        this.unit = unit;
    }

    public E getDepartment() {
        return department;
    }

    public void setDepartment(E department) {
        this.department = department;
    }
}
