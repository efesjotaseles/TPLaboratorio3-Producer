package ElementClasses.Persons;

import CustomExceptions.E_NoActionsLeft;
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
        try {
            takeAction();
        } catch (E_NoActionsLeft e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sell(Element item, int cash) {
        try {
            takeAction();
        } catch (E_NoActionsLeft e) {
            throw new RuntimeException(e);
        }

    }
}
