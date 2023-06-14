package Model.Interfaces.Base;

import Model.Abstracts.Base.Entity;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface EntityGroupInterface<T extends Entity> {

    Map<Long, T> getStructure();

    List<Long> getKeys();

    List<T> getValues();

    T getValue(Long UUID);

    List<T> sorted(Comparator<T> comparator);

    void add(T value);

    void add(List<T> values);

    void remove(Long UUID);

    void remove(List<Long> UUIDs);
}
