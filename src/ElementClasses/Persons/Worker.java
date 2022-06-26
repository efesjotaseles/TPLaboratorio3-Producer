package ElementClasses.Persons;

import CustomExceptions.E_NoActionsLeft;
import ElementClasses.Element;
import Interfaces.Fabricator;

public class Worker extends Person implements Fabricator, Cloneable{

    public Worker() {
        super(30);
        this.setActionsLimit(1);
    }

    @Override
    public Element fabricate() {
        if(hasActions()){
            takeAction();
        }
        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Worker();
    }
}
