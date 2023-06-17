package Application.Model.Entities.UsersGroups;

import Application.Model.Abstract.Users.UserImpl;
import Application.Model.Interfaces.UsersGroups.UsersGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UsersGroupImpl<T extends UserImpl> implements UsersGroup<T> {

    private Map<String, T> group;

    public UsersGroupImpl(Map<String, T> group) {
        setStructure(group);
    }

    public UsersGroupImpl(List<T> group) {
        this();
        add(group);
    }

    public UsersGroupImpl() {
        this(new HashMap<>());
    }

    public Map<String, T> getStructure() {
        return group;
    }

    public void setStructure(Map<String, T> group) {
        this.group = group;
    }

    @Override
    public void add(List<T> group) {
        for (T user :
                Objects.requireNonNull(group)) {
            add(user);
        }
    }

    @Override
    public void add(T user) {
        Objects.requireNonNull(user);
        getStructure().put(user.getUUID(), user);
    }
}
