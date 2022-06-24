package App;


//import ElementClasses.BaseMaterials.Metal;

import Console.Console;
import ElementClasses.BaseMaterials.BaseMaterial;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Console.info(new int[]{10, 20, 1, 30});

        Class c;
        Object o;
        BaseMaterial baseMaterial;
        //Deprecated way
        /*
        try {
            c = Class.forName("ElementClasses.BaseMaterials.Metal");
            o = c.newInstance();
            baseMaterial = (BaseMaterial) o;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
         */

        /*
        try {
            c = Class.forName("ElementClasses.BaseMaterials.Metal");
            o = c.getDeclaredConstructor().newInstance();
            baseMaterial = (BaseMaterial) o;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
         */

        //System.out.println(baseMaterial.toString());




    }
}
