package Services.User;

import Model.Abstracts.Users.User;

public class UserService<T extends User> {

    private T user;

    public UserService(T user) {
        setUser(user);
    }

    public UserService() {
        this(null);
    }

    // TODO: 15.06.2023 Подумать как добавить инициализацию пользователя (учитель / студент)

    private T getUser() {
        return user;
    }

    private void setUser(T user) {
        this.user = user;
    }

    /**
     * @return Уникальный идентификатор пользователя
     */
    public Long getUsersUUID() {
        return getUser().getUUID();
    }

    /**
     * Обновляет имя пользователя.
     * @param name Новое имя пользователя.
     * @return Предыдущее имя пользователя.
     */
    public String updateName(String name) {
        String previousName = getUser().getFirstName();
        getUser().setFirstName(name);
        return previousName;
    }

    /**
     * Обновляет фамилию пользователя.
     * @param surname Новая фамилия пользователя.
     * @return Предыдущая фамилия пользователя.
     */
    public String updateSurname(String surname) {
        String previousSurname = getUser().getLastName();
        getUser().setLastName(surname);
        return previousSurname;
    }

    /**
     * @return Представление пользователя
     */
    public String getUserDeclaration() {
        return getUser().toString();
    }
}
