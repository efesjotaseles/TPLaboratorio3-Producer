package GameEntities;

import ElementClasses.Element;
import Interfaces.Trader;

public class GameState {
    private Player player;
    private int currentDay;
    private int dueDay;
    private int goalCash;

    public GameState(int dueDay, int goalCash) {
        player = null;
        currentDay = 1;
        this.dueDay = dueDay;
        this.goalCash = goalCash;
    }

    public GameState() {
        player = null;
        currentDay = 1;
        dueDay = -1;
        goalCash = -1;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public int getDueDay() {
        return dueDay;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    public int getGoalCash() {
        return goalCash;
    }

    public void setGoalCash(int goalCash) {
        this.goalCash = goalCash;
    }

    public int[] getDailyInfo(){
        return new int[]{getCurrentDay(),getDueDay(),player.getCash(),getGoalCash()};
    }

    public int[] getActions(){
        return player.getActions();
    }

    public void tradeOperation(Trader buyer , Trader seller, Element item){
        Element copy = null;
        try {
            copy = (Element)item.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if(copy != null){
            buyer.buy(copy,copy.getValue());
            seller.sell(item, item.getValue());
        }

    }

    public int playerStuffValue(){
        return player.getStuffValue();
    }

    public int playerBMaterialsValue(){
        return player.getBMaterialsValue();
    }

    public int playerMachinesValue(){
        return player.getMachinesValue();
    }

    public int[] playerValues(){
        return new int[]{playerStuffValue(),playerBMaterialsValue(),playerMachinesValue()};
    }

    public void playerSellEveryStuff(){
        player.sellEveryStuff();
    }

    public void playerSellEveryMachine(){
        player.sellEveryMachine();
    }

    public void playerSellEveryBMaterial(){
        player.sellEveryBMaterial();
    }



}
