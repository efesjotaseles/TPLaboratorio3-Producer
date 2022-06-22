package GameEntities;

import ElementClasses.Element;
import Interfaces.Fabricator;
import Interfaces.Merchant;

public class Player implements Fabricator,Merchant {

    @Override
    public Element fabricate() {
        return null;
    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }
}
