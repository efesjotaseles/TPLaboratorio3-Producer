package GameEntities;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.BaseMaterials.Wood;
import ElementClasses.CompositeStuff.Machines.Machine;
import ElementClasses.Persons.Person;
import Interfaces.Merchant;

import java.util.Random;

public class Market implements Merchant {
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

    public void renewOffer(){
        materialA = randomBaseMaterial();
        materialB = randomBaseMaterial();
        //random machine
        //random person
    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }
}
