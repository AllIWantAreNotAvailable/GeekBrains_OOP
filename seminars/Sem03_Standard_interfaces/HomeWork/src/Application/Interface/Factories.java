package Application.Interface;

import Application.Abstract.RawMaterial;

public interface Factories<T extends RawMaterial> {
    T create();
}
