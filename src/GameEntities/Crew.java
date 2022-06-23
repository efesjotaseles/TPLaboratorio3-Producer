package GameEntities;

import ElementClasses.Element;
import ElementClasses.Persons.Person;
import Interfaces.Fabricator;
import Interfaces.Trader;

import java.util.ArrayList;

public class Crew implements Fabricator,Trader{
    private ArrayList<Person> persons;

    public Crew() {
        persons = new ArrayList<Person>();
    }

    public int getFabricatorActionsLimit(){
        int actionsLimit = 0;
        for (Person p:persons) {
            if(p instanceof Fabricator){
                actionsLimit += p.getActionsLimit();
            }
        }
        return actionsLimit;
    }

    public int getFabricatorActionsTaken(){
        int actionsTaken = 0;
        for (Person p:persons) {
            if(p instanceof Fabricator){
                actionsTaken += p.getActionsTaken();
            }
        }
        return actionsTaken;
    }

    public int getTraderActionsLimit(){
        int actionsLimit = 0;
        for (Person p:persons) {
            if (p instanceof Trader){
                actionsLimit += p.getActionsLimit();
            }
        }
        return actionsLimit;
    }

    public int getTraderActionsTaken(){
        int actionsTaken = 0;
        for (Person p:persons) {
            if(p instanceof Trader){
                actionsTaken += p.getActionsTaken();
            }
        }
        return actionsTaken;
    }

    @Override
    public Element fabricate() {
        boolean done = false;
        for (Person p:persons) {
            if(p instanceof Fabricator && p.hasActions() && !done){
                p.takeAction();
                done = true;
            }
        }
        return null;
    }

    private void trade(){
        boolean done = false;
        for (Person p:persons) {
            if(p instanceof Trader && p.hasActions() && !done){
                p.takeAction();
                done = true;
            }
        }
    }

    @Override
    public void buy(Element item, int cash) {
        trade();
    }

    @Override
    public void sell(Element item, int cash) {
        trade();
    }
}
