package Application.Interface;

import Application.Abstract.AbsProduct;

public interface RawMaterial<T extends AbsProduct> {
    T getPieceOfProduct(float amount) throws Exception;
}
