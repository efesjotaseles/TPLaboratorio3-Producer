package ElementClasses.CompositeStuff.Machines;

import ElementClasses.CompositeStuff.Stuff;
import Interfaces.Fabricator;

public abstract class Machine extends Stuff implements Fabricator, Cloneable {
    public Machine(int value) {
        super(value);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
