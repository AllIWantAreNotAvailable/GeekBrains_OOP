package Application.Objects;

import Application.Abstracts.NatureOrigin;
import Application.Enums.Units;

public class CoffeeBeans extends NatureOrigin {

    public CoffeeBeans(String name, Float volume, Units unit, String place) {
        super(name, volume, unit, place);
    }

    public CoffeeBeans(String name, Float volume, String place) {
        this(name, volume, Units.grams, place);
    }

    @Override
    public void setVolume(float volume) {
        super.volume = volume;
    }

    @Override
    public CoffeeBeans getPieceOfProduct(float amount) {
        float newVolume = super.volume - amount;
        if (0 <= newVolume) {
            super.volume = newVolume;
            return new CoffeeBeans(super.name, amount, super.unit, super.place);
        }
        return null;
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
    public String toString() {
        return super.toString();
    }
}
