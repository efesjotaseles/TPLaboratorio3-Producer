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

    public HashMap<BaseMaterial,Integer> getBaseMaterials(){
        return baseMaterials;
    }

    public ArrayList<Machine> getMachines(){
        return machines;
    }

    public Crew getCrew(){
        return crew;
    }

    private void emptyBMaterials(){
        baseMaterials.replace(new Wood(),0);
        baseMaterials.replace(new Plastic(),0);
        baseMaterials.replace(new Metal(),0);
    }

    @Override
    public Stuff fabricate(int option) {
        if(crew.canFabricate()){
            stuff.add(machines.get(option-1).fabricate(0));
            cash -= machines.get(option-1).getCashCost();
            crew.fabricate(0);
        }

        return null;
    }

    //TODO a more streamlined way to get and show the composition
    public ArrayList<String> fabricateOptions(){
        ArrayList<String> options = new ArrayList<String>();
        for (Machine m:machines) {
            String aux = m.getProduction() + "($ " + m.getCashCost() + ")";
            options.add(aux);
        }
        return options;
    }

    public void addBMaterials(BaseMaterial baseMaterial,int amount){
        int currentAmount = this.baseMaterials.get(baseMaterial);
        int updatedAmount = amount + currentAmount;
        this.baseMaterials.replace(baseMaterial,updatedAmount);
    }

    public void addMachine(Machine machine){
        machines.add(machine);
    }

    public void addPerson(Person person){
        crew.addPerson(person);
    }

    @Override
    public void buy(Element item, int cash) {
        this.cash -= cash;
        crew.trade();
        if(item instanceof Person){
            crew.addPerson((Person) item);
        }
        else if(item instanceof Machine){
            //TODO add item to machines, wrapper????
            machines.add((Machine) item);
        }
        else if(item instanceof Stuff){
            stuff.add((Stuff)item);
        }
        else if(item instanceof BaseMaterial){
            addBMaterials((BaseMaterial) item,1);
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

    public void sellEveryStuff(){
        crew.trade();
        cash += getStuffValue();
        stuff.clear();
    }

    public void sellEveryMachine(){
        cash += getMachinesValue();
        machines.clear();
    }

    public void sellEveryBMaterial(){
        cash += getBMaterialsValue();
        emptyBMaterials();
    }

    /*
    public void deployMachine(){
        //Moves a Machine from the Stuff collection to the Machines collection
    }
     */


}
