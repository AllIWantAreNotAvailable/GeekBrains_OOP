package Application.Model.Abstract.Users;

public abstract class User {

    protected String name;
    protected String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


}
