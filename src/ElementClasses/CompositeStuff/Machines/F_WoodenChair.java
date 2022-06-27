package ElementClasses.CompositeStuff.Machines;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Furniture.WoodenChair;
import ElementClasses.CompositeStuff.Stuff;
import ElementClasses.Element;
import Interfaces.Fabricator;

import java.util.HashMap;

public class F_WoodenChair extends Machine implements Cloneable{
    public F_WoodenChair() {
        super(50);
        composition.replace(new Metal(),10);
    }

    @Override
    public String getProduction() {
        return "Wooden Chair";
    }

    @Override
    public int getCashCost() {
        return 1;
    }

    @Override
    public HashMap<Element, Integer> getMaterialsNeeded() {
        Stuff aux = new WoodenChair();
        return aux.getComposition();
    }

    @Override
    public Element fabricate() {
        return new WoodenChair();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof F_WoodenChair);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new F_WoodenChair();
    }

    @Override
    public String toString() {
        return "Fabricator of Wooden Chair";
    }
}
