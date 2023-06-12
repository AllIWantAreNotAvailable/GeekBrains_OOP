package Interfaces;

public interface UserInterface {

    Long getUUID();
    boolean updateUUID(long UUID);
    String getFirstName();
    boolean updateFirstName(String firstName);
    String getLastName();
    boolean updateLastName(String lastName);

}
