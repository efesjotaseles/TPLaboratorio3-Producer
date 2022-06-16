package ElementClasses.CompositeStuff;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.Element;

import java.util.HashMap;


public class Stuff extends Element {
    protected HashMap<Element,Integer> composition;

    public Stuff(int value) {
        super(value);
        composition = new HashMap<Element,Integer>();
    }

    public void addBaseMaterial(BaseMaterial baseMaterial , int amount){
        //composition.merge(baseMaterial,(Integer)amount,Integer::sum);
        if(!composition.containsKey(baseMaterial)){
            composition.put(baseMaterial,amount);
        }
        else{
            System.out.println(composition.get(baseMaterial));
            amount += composition.get(baseMaterial);
            composition.remove(baseMaterial);
            composition.put(baseMaterial,amount);
        }
    }

    public HashMap<Element,Integer> getComposition(){
        return composition;
    }


}
