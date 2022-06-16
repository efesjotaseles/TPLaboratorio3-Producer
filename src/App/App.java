package App;


import ElementClasses.CompositeStuff.Furniture.*;



import Interfaces.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        WoodenChair sillita = new WoodenChair();
        System.out.println(sillita.getValue());
        System.out.println(sillita.getComposition().toString());



    }
}
