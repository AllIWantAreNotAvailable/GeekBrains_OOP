package Model.Interfaces.Users;

import Model.Abstracts.Users.User;
import Model.Interfaces.Base.EntityInterface;

public interface UserInterface extends EntityInterface<User> {

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);
}
