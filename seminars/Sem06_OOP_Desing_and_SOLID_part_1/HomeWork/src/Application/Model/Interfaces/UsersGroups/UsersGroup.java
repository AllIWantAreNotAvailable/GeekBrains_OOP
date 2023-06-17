package Application.Model.Interfaces.UsersGroups;

import Application.Model.Abstract.Users.UserImpl;

import java.util.List;

public interface UsersGroup<T extends UserImpl> {

    void add(List<T> group);

    void add(T user);
}
