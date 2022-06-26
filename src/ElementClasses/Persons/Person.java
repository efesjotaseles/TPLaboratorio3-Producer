package ElementClasses.Persons;

import CustomExceptions.E_NoActionsLeft;
import ElementClasses.Element;

public abstract class Person extends Element implements Cloneable{
    //private String name;
    private int actionsLimit;
    private int actionsTaken = 0;

    public Person(int value) {
        super(value);
        actionsLimit = 0;
    }

    public int getActionsLimit() {
        return actionsLimit;
    }

    public void setActionsLimit(int actionsLimit) {
        this.actionsLimit = actionsLimit;
    }

    public int getActionsTaken() {
        return actionsTaken;
    }

    public void setActionsTaken(int actionsTaken) {
        this.actionsTaken = actionsTaken;
    }

    public int actionsLeft(){
        return actionsLimit-actionsTaken;
    }

    public boolean hasActions(){
        return actionsLeft()>0;
    }

    public void takeAction() {
        if (hasActions()) {
            actionsTaken++;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
