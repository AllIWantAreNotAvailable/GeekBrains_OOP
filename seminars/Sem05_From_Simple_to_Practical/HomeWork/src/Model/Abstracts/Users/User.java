package Model.Abstracts.Users;

import Model.Abstracts.Base.Entity;
import Model.Interfaces.Users.UserInterface;

public abstract class User extends Entity implements UserInterface {

    protected String lastName;

    protected String firstName;

    public User(String lastName, String firstName) {
        super();
        setLastName(lastName);
        setFirstName(firstName);
    }
}
