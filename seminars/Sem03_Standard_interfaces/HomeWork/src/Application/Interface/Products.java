package Application.Interface;

import Application.Enums.Units;

public interface Products {
    String getName();
    void setName(String name);
    Float getVolume();
    void setVolume(Float volume);
    Units getUnit();
    void setUnit(Units unit);
}
