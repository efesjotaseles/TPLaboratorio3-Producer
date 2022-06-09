package ElementClasses.CompositeStuff;

import ElementClasses.Element;

import java.util.HashMap;

public class Stuff extends Element {
    private HashMap<Element,Integer> composition;

    public Stuff(int value) {
        super(value);
    }
}
