package ElementClasses.CompositeStuff.Furniture;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Stuff;

public class MetalChair extends Stuff implements Cloneable{
    public MetalChair() {
        super(30);
        composition.replace(new Metal(),4);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new MetalChair();
    }
}
