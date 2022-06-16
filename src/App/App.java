package App;


import ElementClasses.*;
import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.CompositeStuff.Stuff;
import Interfaces.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Stuff cosita = new Stuff(50);
        cosita.addBaseMaterial(new Plastic(),2);
        cosita.addBaseMaterial(new Plastic(),5);
        cosita.addBaseMaterial(new Metal(),60);
        cosita.addBaseMaterial(new Metal(),40);
        System.out.println(cosita.getComposition().toString());


    }
}
