package ElementClasses.CompositeStuff.Machines;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Furniture.MetalChair;
import ElementClasses.CompositeStuff.Stuff;
import ElementClasses.Element;

import java.util.HashMap;

public class F_MetalChair extends Machine implements Cloneable{
    public F_MetalChair() {
        super(90);
        composition.replace(new Metal(),15);
    }

    @Override
    public String getProduction() {
        return "Metal Chair";
    }

    @Override
    public int getCashCost() {
        return 2;
    }

    @Override
    public HashMap<Element, Integer> getMaterialsNeeded() {
        Stuff aux = new MetalChair();
        return aux.getComposition();
    }

    @Override
    public Stuff fabricate(int option) {
        return new MetalChair();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new F_MetalChair();
    }

    @Override
    public String toString() {
        return "Fabricator of Metal Chair";
    }

    @Override
    public String toJSON(){
        return "ElementClasses.CompositeStuff.Machines.F_MetalChair";
    }
}
