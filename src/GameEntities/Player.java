package GameEntities;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.CompositeStuff.Machines.Machine;
import ElementClasses.CompositeStuff.Stuff;
import ElementClasses.Element;
import ElementClasses.Persons.Person;
import Interfaces.Fabricator;
import Interfaces.Trader;

import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Fabricator, Trader {

    private Crew crew;
    private ArrayList<Machine> machines;
    private ArrayList<Stuff> stuff;
    private HashMap<BaseMaterial,Integer> baseMaterials;
    private int cash;

    public Player() {
        crew = new Crew();
        machines = new ArrayList<Machine>();
        stuff = new ArrayList<Stuff>();
        baseMaterials = new HashMap<BaseMaterial,Integer>();
        cash = 0;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }



    @Override
    public Element fabricate() {
        return null;
    }

    @Override
    public void buy(Element item, int cash) {
        this.cash -= cash;
        if(item instanceof Person){
            crew.addPerson((Person) item);
        }
        else if(item instanceof Machine){
            //TODO add item to machines, wrapper????
        }
        else if(item instanceof Stuff){
            stuff.add((Stuff)item);
        }

    }

    @Override
    public void sell(Element item, int cash) {
        this.cash += cash;
        //TODO REMOVE ITEM FROM ATTRIBUTES
    }

    public void deployMachine(){
        //Moves a Machine from the Stuff collection to the Machines collection
    }


}
