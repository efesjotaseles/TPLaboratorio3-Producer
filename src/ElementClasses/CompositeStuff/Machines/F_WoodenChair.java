package ElementClasses.CompositeStuff.Machines;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Furniture.WoodenChair;
import ElementClasses.CompositeStuff.Stuff;
import ElementClasses.Element;
import Interfaces.Fabricator;

public class F_WoodenChair extends Machine {
    public F_WoodenChair() {
        super(50);
        composition.put(new Metal(),10);
    }

    @Override
    public Element fabricate() {
        return new WoodenChair();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof F_WoodenChair);
    }
}
