package ElementClasses.CompositeStuff.Furniture;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Stuff;

public class MetalChair extends Stuff {
    public MetalChair() {
        super(30);
        composition.put(new Metal(),4);
    }
}
