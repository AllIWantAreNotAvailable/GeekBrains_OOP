package Application.Abstract;

import Application.Enums.Units;
import Application.Interface.RawMaterial;

public abstract class AbsNatureOrigin extends AbsProduct implements RawMaterial<AbsProduct> {
    protected String place;

    public AbsNatureOrigin(String name, Float volume, Units unit, String place) {
        super(name, volume, unit);
        this.place = place;
    }


}
