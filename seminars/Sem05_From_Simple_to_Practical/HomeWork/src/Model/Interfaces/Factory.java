package Model.Interfaces;

import Model.Abstracts.User;

import java.util.List;

public interface Factory<T extends User> {

    T create();

    List<T> createList(int quantity);



}
