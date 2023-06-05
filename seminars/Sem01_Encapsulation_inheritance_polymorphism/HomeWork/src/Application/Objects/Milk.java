package Application.Objects;

import Application.Abstracts.NatureOrigin;
import Application.Enums.Units;
import Application.Interfaces.Products;

public class Milk extends NatureOrigin {
    public Milk(String name, Float volume, Units unit, String place) {
        super(name, volume, unit, place);
    }

    public Milk(String name, Float volume, String place) {
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
    public String getPlace() {
        return super.place;
    }

    @Override
    public void setVolume(float volume) {
        super.volume = volume;
    }

    @Override
    public Products getPieceOfProduct(float amount) {
        float newVolume = super.volume - amount;
        if (0 <= newVolume) {
            Products water = new Water(super.name, amount, super.place);
            setVolume(newVolume);
            return water;
        }
        return null;
    }
}
