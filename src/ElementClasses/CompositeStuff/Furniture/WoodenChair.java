package ElementClasses.CompositeStuff.Furniture;

import ElementClasses.BaseMaterials.Wood;
import ElementClasses.CompositeStuff.Stuff;

public class WoodenChair extends Stuff implements Cloneable{
    public WoodenChair() {
        super(8);
        composition.put(new Wood(),4);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new WoodenChair();
    }
}
