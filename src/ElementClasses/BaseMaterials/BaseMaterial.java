package ElementClasses.BaseMaterials;

import ElementClasses.Element;

public abstract class BaseMaterial extends Element implements Cloneable{

    public BaseMaterial(int value) {
        super(value);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
