package Model.Interfaces;

import Model.Abstracts.User;

import java.util.List;

public interface Factory<T extends User> {

    T create(Class<T> tClass);

    List<T> createList(Class<T> tClass, int quantity);

}
