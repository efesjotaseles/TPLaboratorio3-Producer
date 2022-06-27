package ElementClasses.CompositeStuff.Machines;

import ElementClasses.CompositeStuff.Stuff;
import ElementClasses.Element;
import Interfaces.Fabricator;

import java.util.HashMap;

public abstract class Machine extends Stuff implements Fabricator, Cloneable {
    public Machine(int value) {
        super(value);
    }

    public String getProduction(){
        return null;
    }

    public int getCashCost(){
        return 0;
    }

    public HashMap<Element,Integer> getMaterialsNeeded(){
        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
