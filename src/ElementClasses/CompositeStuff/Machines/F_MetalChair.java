package ElementClasses.CompositeStuff.Machines;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Furniture.MetalChair;
import ElementClasses.Element;

public class F_MetalChair extends Machine{
    public F_MetalChair() {
        super(90);
        composition.put(new Metal(),15);
    }

    @Override
    public Element fabricate() {
        return new MetalChair();
    }
}
