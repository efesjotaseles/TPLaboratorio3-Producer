package GameEntities;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.BaseMaterials.Wood;
import ElementClasses.CompositeStuff.Machines.F_MetalChair;
import ElementClasses.CompositeStuff.Machines.F_WoodenChair;
import ElementClasses.CompositeStuff.Machines.Machine;
import ElementClasses.Element;
import ElementClasses.Persons.Person;
import Interfaces.Trader;

import java.util.Random;

public class Market implements Trader {
    private Random random;
    //The next variables are the items available to purchase.
    private BaseMaterial materialA;
    private BaseMaterial materialB;
    private Machine machine;
    private Person crew;

    public Market() {
        random = new Random(System.currentTimeMillis());
        materialA = null;
        materialB = null;
        machine = null;
        crew = null;
    }

    private BaseMaterial randomBaseMaterial(){
        BaseMaterial baseMaterial = null;
        //If new BaseMaterials are added, increment the bound parameter on .nextInt()
        switch (random.nextInt(0,3)){
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

    private Machine randomMachine(){
        Machine machine = null;
        //If new Machines are added, increment the bound parameter on .nextInt()
        switch (random.nextInt(0,2)){
            case 0:
                machine = new F_WoodenChair();
                break;
            case 1:
                machine = new F_MetalChair();
                break;
        }
        return machine;
    }

    private Person randomPerson(){
        Person person = null;
        //TODO switch for randomPerson
        return person;
    }

    public void renewOffer(){
        materialA = randomBaseMaterial();
        materialB = randomBaseMaterial();
        //random machine
        //random person
    }

    @Override
    public void buy(Element item, int cash) {

    }

    @Override
    public void sell(Element item, int cash) {

    }
}
