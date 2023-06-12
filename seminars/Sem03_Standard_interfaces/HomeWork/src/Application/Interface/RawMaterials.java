package Application.Interface;

import Application.Abstract.Product;
import Application.Abstract.RawMaterial;
import Application.Enums.Unit;

// TODO: 08.06.2023 Подумать Ликвидации интерфейса RawMaterials, в связи с переносом метода
//  getPieceOfProduct(Float volume, Unit unit) в интерфейс Factory
public interface RawMaterials {

    String getPlaceOfOrigin();

    void setPlaceOfOrigin(String placeOfOrigin);

    // TODO: 08.06.2023 Подумать о переносе метода getPieceOfProduct(Float volume, Unit unit) в интерфейс Factory
    Product getPieceOfProduct(Float volume, Unit unit) throws Exception;

    void transferVolume(RawMaterial product, Float volume, Unit unit) throws Exception;

}
