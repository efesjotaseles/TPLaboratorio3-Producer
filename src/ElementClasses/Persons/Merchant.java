package ElementClasses.Persons;

import ElementClasses.Element;
import Interfaces.Trader;

public class Merchant extends Person implements Trader {

    public Merchant(String name) {
        super(name);
        this.setActionsLimit(2);
    }

    public Merchant() {
        super();
        this.setActionsLimit(2);
    }

    @Override
    public void buy(Element item, int cash) {
        takeAction();

    }

    @Override
    public void sell(Element item, int cash) {

    }
}
