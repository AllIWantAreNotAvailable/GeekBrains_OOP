package Application.Model.Interfaces.Services;

import Application.Model.Abstract.Users.UserImpl;
import Application.Model.Interfaces.Users.User;

import java.time.LocalDate;

public interface UserService<T extends UserImpl> extends User {

    T create(String UUID, String surname, String name, LocalDate dateOfBirth);
}
