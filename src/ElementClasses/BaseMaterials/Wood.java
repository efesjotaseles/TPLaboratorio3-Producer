package ElementClasses.BaseMaterials;

import ElementClasses.BaseMaterials.BaseMaterial;

public class Wood extends BaseMaterial implements Cloneable{
    public Wood() {
        super(1);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Wood);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Wood();
    }

    @Override
    public String toString() {
        return "Wood";
    }


}
