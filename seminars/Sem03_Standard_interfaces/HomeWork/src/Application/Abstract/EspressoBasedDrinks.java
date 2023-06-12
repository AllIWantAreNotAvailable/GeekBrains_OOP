package Application.Abstract;

import Application.Objects.Products.Espresso;

import java.util.Objects;

public abstract class EspressoBasedDrinks extends Product{
    protected Espresso espresso;

    public EspressoBasedDrinks(String name, Espresso espresso) {
        super(name, espresso.getVolume(), espresso.getUnit());
        setEspresso(espresso);
    }

    public abstract Espresso getEspresso();

    public abstract void setEspresso(Espresso espresso);

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof EspressoBasedDrinks that)) return false;
            return Objects.equals(getEspresso(), that.getEspresso());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEspresso());
    }

    @Override
    public String toString() {
        return "EspressoBasedDrinks{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", espresso=" + getEspresso() +
                '}';
    }
}
