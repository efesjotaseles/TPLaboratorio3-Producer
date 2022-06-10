package ElementClasses.CompositeStuff;

import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Stuff extends Element {
    private Map<Element,Integer> composition;

    public Stuff(int value) {
        super(value);
        composition = new HashMap<Element,Integer>();
    }

    public void addBaseMaterial(BaseMaterial baseMaterial , int amount){
        composition.merge(baseMaterial,(Integer)amount,Integer::sum);
    }

    public String getComposition(){
        StringBuilder message = new StringBuilder();
        Iterator<Map.Entry<Element,Integer>> iterator = composition.entrySet().iterator();
        while (iterator.hasNext()){
            ???
        }


        return message.toString();
    }


}
