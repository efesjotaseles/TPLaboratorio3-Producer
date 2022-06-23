package ElementClasses.Persons;

import CustomExceptions.E_NoActionsLeft;
import ElementClasses.Element;
import Interfaces.Fabricator;

public class Worker extends Person implements Fabricator {

    public Worker(String name) {
        super(name);
        this.setActionsLimit(1);
    }

    public Worker() {
        super();
        this.setActionsLimit(1);
    }

    @Override
    public Element fabricate() {
        try {
            takeAction();
        } catch (E_NoActionsLeft e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
