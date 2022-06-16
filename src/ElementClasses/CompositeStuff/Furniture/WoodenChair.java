package ElementClasses.CompositeStuff.Furniture;

import ElementClasses.BaseMaterials.Wood;
import ElementClasses.CompositeStuff.Stuff;

public class WoodenChair extends Stuff {
    public WoodenChair() {
        super(10);
        composition.put(new Wood(),4);
    }
}
