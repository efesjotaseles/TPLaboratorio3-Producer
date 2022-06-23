package ElementClasses.Persons;

public abstract class Person {
    private String name;
    private int actionsLimit;
    private int actionsTaken = 0;

    public Person(String name) {
        this.name = name;
        actionsLimit = 0;
    }

    public Person() {
        name = "";
        actionsLimit = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void takeAction(){
        if(hasActions()){
            actionsTaken++;
        }
        else{
            //TODO EXCEPTION NOACTIONSLEFT
        }
    }
}
