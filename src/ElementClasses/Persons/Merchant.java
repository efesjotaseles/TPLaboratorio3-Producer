package ElementClasses.Persons;

import CustomExceptions.E_NoActionsLeft;
import ElementClasses.Element;
import Interfaces.Trader;

public class Merchant extends Person implements Trader, Cloneable{

    public Merchant() {
        super(20);
        this.setActionsLimit(2);
    }

    @Override
    public void buy(Element item, int cash) {
        if(hasActions()) {
            takeAction();
        }

    }

    @Override
    public void sell(Element item, int cash) {
        if(hasActions()){
            takeAction();
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Merchant();
    }

    @Override
    public String toJSON() {
        return "ElementClasses.Persons.Merchant";
    }
}
