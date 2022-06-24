package GameEntities;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.BaseMaterials.Wood;
import ElementClasses.CompositeStuff.Machines.F_MetalChair;
import ElementClasses.CompositeStuff.Machines.F_WoodenChair;
import ElementClasses.CompositeStuff.Machines.Machine;
import ElementClasses.Element;
import ElementClasses.Persons.Merchant;
import ElementClasses.Persons.Person;
import ElementClasses.Persons.Worker;
import Interfaces.Trader;

import java.util.ArrayList;
import java.util.Random;

public class Market implements Trader {
    private Random random;
    //The next variables are the items available to purchase.
    private BaseMaterial materialA;
    private BaseMaterial materialB;
    private Machine machine;
    private Person person;

    public Market() {
        random = new Random(System.currentTimeMillis());
        materialA = null;
        materialB = null;
        machine = null;
        person = null;
    }

    public BaseMaterial getMaterialA() {
        return materialA;
    }

    public void setMaterialA(BaseMaterial materialA) {
        this.materialA = materialA;
    }

    public BaseMaterial getMaterialB() {
        return materialB;
    }

    public void setMaterialB(BaseMaterial materialB) {
        this.materialB = materialB;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private BaseMaterial randomBaseMaterial() {
        BaseMaterial baseMaterial = null;
        //If new BaseMaterials are added, increment the bound parameter on .nextInt()
        switch (random.nextInt(0, 3)) {
            case 0:
                baseMaterial = new Wood();
                break;
            case 1:
                baseMaterial = new Plastic();
                break;
            case 2:
                baseMaterial = new Metal();
                break;
        }
        return baseMaterial;
    }

    private Machine randomMachine() {
        Machine machine = null;
        //If new Machines are added, increment the bound parameter on .nextInt()
        switch (random.nextInt(0, 2)) {
            case 0:
                machine = new F_WoodenChair();
                break;
            case 1:
                machine = new F_MetalChair();
                break;
        }
        return machine;
    }

    private Person randomPerson() {
        Person person = null;
        //If new Persons are added, increment the bound parameter on .nextInt()
        switch (random.nextInt(0, 2)) {
            case 0:
                person = new Worker();
                break;
            case 1:
                person = new Merchant();
                break;
        }
        return person;
    }

    public void renewOffer() {
        materialA = randomBaseMaterial();
        materialB = randomBaseMaterial();
        machine = randomMachine();
        person = randomPerson();
    }

    @Override
    public void buy(Element item, int cash) {

    }

    @Override
    public void sell(Element item, int cash) {

    }

    public ArrayList<String> offerToString() {
        ArrayList<String> offer = new ArrayList<String>();
        if (materialA != null) {
            offer.add(materialA.toString());
        } else {
            offer.add("-empty-");
        }

        if (materialB != null) {
            offer.add(materialB.toString());
        } else {
            offer.add("-empty-");
        }

        if(machine != null){
            offer.add(machine.toString());
        }
        else{
            offer.add("-empty-");
        }

        if(person != null){
            offer.add(person.toString());
        }
        else{
            offer.add("-empty-");
        }

        return offer;
    }
}