package Model.Interfaces.Users;

import Model.Abstracts.Users.User;

public interface UserInterface<T extends User> {

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);
}
