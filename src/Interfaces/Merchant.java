package Interfaces;

import ElementClasses.Element;

public interface Merchant {
    public void buy(Element item , int cash);
    public void sell(Element item , int cash);
}
