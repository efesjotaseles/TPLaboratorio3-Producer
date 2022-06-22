package ElementClasses.CompositeStuff.Machines;

import ElementClasses.CompositeStuff.Stuff;
import Interfaces.Fabricator;

public abstract class Machine extends Stuff implements Fabricator {
    public Machine(int value) {
        super(value);
    }
}
