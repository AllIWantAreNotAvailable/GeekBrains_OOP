package Application.Objects;

import Application.Abstracts.Product;
import Application.Interfaces.FinalProducts;
import Application.Enums.Units;

public class ChocolateBars extends Product implements FinalProducts {
    public ChocolateBars(String name, Float volume) {
        super(name, volume);
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
    public String toString() {
        return "ChocolateBars{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", unit=" + unit +
                '}';
    }
}
