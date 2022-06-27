package GameEntities;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.BaseMaterials.Wood;
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
        baseMaterials.put(new Wood(),0);
        baseMaterials.put(new Plastic(),0);
        baseMaterials.put(new Metal(),0);
        cash = 0;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int[] getActions(){
        return crew.getActions();
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
        else if(item instanceof BaseMaterial){
            baseMaterials.put((BaseMaterial) item,1);
        }

    }

    @Override
    public void sell(Element item, int cash) {
        this.cash += cash;
        //TODO REMOVE ITEM FROM ATTRIBUTES
    }

    public int getStuffValue(){
        int result = 0;
        for (Stuff s:stuff) {
            result += s.getValue();
        }
        return result;
    }

    public int getBMaterialsValue(){
        int valueTotal = 0;
        BaseMaterial aux = new Wood();
        valueTotal += (baseMaterials.get(aux)*aux.getValue());
        aux = new Plastic();
        valueTotal += (baseMaterials.get(aux)*aux.getValue());
        aux = new Metal();
        valueTotal += (baseMaterials.get(aux)*aux.getValue());

        return valueTotal;
    }

    public int getMachinesValue(){
        int result = 0;
        for (Machine m:machines) {
            result += m.getValue();
        }

        return result;
    }

    public void deployMachine(){
        //Moves a Machine from the Stuff collection to the Machines collection
    }


}
