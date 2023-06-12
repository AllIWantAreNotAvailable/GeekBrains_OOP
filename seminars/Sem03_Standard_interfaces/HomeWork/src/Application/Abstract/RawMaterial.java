package Application.Abstract;

import Application.Enums.Unit;
import Application.Interface.RawMaterials;

import java.util.Objects;

// TODO: 08.06.2023 Подумать Ликвидации абстрактного класса RawMaterial, в связи с переносом метода
//  getPieceOfProduct(Float volume, Unit unit) в интерфейс Factory
public abstract class RawMaterial extends Product implements RawMaterials {
    protected String placeOfOrigin;

    public RawMaterial(String name, Float volume, Unit unit, String placeOfOrigin) {
        super(name, volume, unit);
        setPlaceOfOrigin(placeOfOrigin);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof RawMaterial that)) return false;
            return Objects.equals(getPlaceOfOrigin(), that.getPlaceOfOrigin());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPlaceOfOrigin());
    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", placeOfOrigin='" + getPlaceOfOrigin() + '\'' +
                '}';
    }
}
