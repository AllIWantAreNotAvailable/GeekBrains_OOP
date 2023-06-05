package Application.Objects;

import Application.Abstracts.NatureOrigin;
import Application.Enums.Units;

public class Water extends NatureOrigin {
    public Water(String name, Float volume, Units unit, String place) {
        super(name, volume, unit, place);
    }

    public Water(String name, Float volume, String place) {
        super(name, volume, Units.milliliters, place);
    }


    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public Float getVolume() {
        return super.volume;
    }

    @Override
    public Units getUnit() {
        return super.unit;
    }

    @Override
    public void setVolume(float volume) {
        super.volume = volume;
    }

    @Override
    public String getPlace() {
        return null;
    }

    @Override
    public Water getPieceOfProduct(float amount) {
        float newVolume = super.volume - amount;
        if (0 <= newVolume) {
            Water water = new Water(super.name, amount, super.place);
            setVolume(newVolume);
            return water;
        }
        return null;
    }
}
