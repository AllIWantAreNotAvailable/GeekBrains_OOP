package Application.Objects.RawMaterials;

import Application.Abstract.Product;
import Application.Abstract.RawMaterial;
import Application.Enums.Unit;

public class CoffeeBeans extends RawMaterial {

    public CoffeeBeans(String name, Float volume, Unit unit, String placeOfOrigin) {
        super(name, volume, unit, placeOfOrigin);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public Float getVolume() {
        return super.volume;
    }

    @Override
    public void setVolume(Float volume) {
        super.volume = volume;
    }

    @Override
    public Unit getUnit() {
        return super.unit;
    }

    @Override
    public void setUnit(Unit unit) {
        super.unit = unit;
    }

    @Override
    public String getPlaceOfOrigin() {
        return super.placeOfOrigin;
    }

    @Override
    public void setPlaceOfOrigin(String placeOfOrigin) {
        super.placeOfOrigin = placeOfOrigin;
    }

    @Override
    public Product getPieceOfProduct(Float volume, Unit unit) throws Exception {
        // TODO: 08.06.2023 Подумать о переносе метода getPieceOfProduct(Float volume, Unit unit) в интерфейс Factory
        float newVolume = getVolume() - volume;
        if (0 <= newVolume) {
            setVolume(newVolume);
            return new CoffeeBeans(getName(), volume, unit, getPlaceOfOrigin());
        }
        throw new Exception("Instance initialization error");
    }

    @Override
    public void transferVolume(RawMaterial product, Float volume, Unit unit) throws Exception {
        boolean exception = true;
        if (product != this
                && product instanceof CoffeeBeans anotherCoffeeBeans
                && volume != null
                && unit != null) {
            float newVolume = this.getVolume() - volume;
            if (0 <= newVolume) {
                exception = false;
                this.setVolume(newVolume);
                anotherCoffeeBeans.setVolume(anotherCoffeeBeans.getVolume() + volume);
            }
        }
        if (exception) throw new Exception("Transfer volume error");
    }

    @Override
    public String toString() {
        return "CoffeeBeans{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", placeOfOrigin='" + getPlaceOfOrigin() + '\'' +
                '}';
    }
}
