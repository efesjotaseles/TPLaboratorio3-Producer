package ElementClasses.Persons;

import ElementClasses.Element;
import Interfaces.Fabricator;

public class Worker extends Person implements Fabricator {

    public Worker(String name) {
        super(name);
    }

    @Override
    public Element fabricate() {
        return null;
    }
}