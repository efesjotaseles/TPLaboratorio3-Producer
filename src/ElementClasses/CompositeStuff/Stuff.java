package ElementClasses.CompositeStuff;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.BaseMaterials.Wood;
import ElementClasses.Element;

import java.util.HashMap;


public abstract class Stuff extends Element implements Cloneable{
    //Until a better way to execute the composition, it is restringed to the 3 baseMaterials
    protected HashMap<Element,Integer> composition;

    public Stuff(int value) {
        super(value);
        composition = new HashMap<Element,Integer>();
        //Until a better way to execute the composition, it is formed exclusively by the 3 baseMaterials
        composition.put(new Wood(),0);
        composition.put(new Plastic(),0);
        composition.put(new Metal(),0);
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
