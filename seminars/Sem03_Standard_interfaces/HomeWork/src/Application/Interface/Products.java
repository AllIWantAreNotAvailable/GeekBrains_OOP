package Application.Interface;

import Application.Enums.Unit;

public interface Products {

    String getName();

    void setName(String name);

    Float getVolume();

    void setVolume(Float volume);

    Unit getUnit();

    void setUnit(Unit unit);

}
