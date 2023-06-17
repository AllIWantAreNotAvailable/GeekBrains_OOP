package Application.Model.Interfaces.Users;

import java.time.LocalDate;

public interface User {

    String getUUID();

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);
}
