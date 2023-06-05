package Application.Abstracts;

import Application.Enums.Units;
import Application.Interfaces.RawMaterials;

public abstract class NatureOrigin extends Product implements RawMaterials {
    protected String place;

    public NatureOrigin(String name, Float volume, Units unit, String place) {
        super(name, volume, unit);
        this.place = place;
    }

    public abstract String getPlace();
}
