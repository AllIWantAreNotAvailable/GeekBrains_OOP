package Model.Interfaces.Users;

import Model.Entities.Users.User;
import Model.Interfaces.Base.EntityInterface;

import java.time.LocalDate;

public interface UserInterface<T extends User> extends EntityInterface<T> {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);
}
