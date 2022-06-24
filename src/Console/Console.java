package Console;

import java.util.ArrayList;

public class Console {

    private static void divScreen(){
        System.out.println("--------------------------------------------------");
    }

    public static void mainMenu(){
        divScreen();
        System.out.println("1) Continue Game");
        System.out.println("2) Start New Game");
        divScreen();
    }

    public static void info(int[] data){
        System.out.println("Day: " + data[0] + " | Due Day: " + data[1]);
        System.out.println("Cash: " + data[2] + " | Goal: " + data[3]);

    }

    /**
     *
     * @param data [currentDay, dueDay, currentCash, goalCash]
     * @param tradeActions [actionsTaken, actionsLimit]
     * @param fabricateActions [actionsTaken, actionsLimit]
     */
    public static void dailyMenu(int[] data, int[]tradeActions, int[] fabricateActions){
        divScreen();
        info(data);
        divScreen();
        System.out.println("1) Market (" + tradeActions[0] + "/" + tradeActions[1] + ")");
        System.out.println("2) Fabricate (" + fabricateActions[0] + "/" + fabricateActions[1] + ")");
        System.out.println("3) Manage Machines");
        System.out.println("4) End the day");
        System.out.println("5) Pay debt!");
        System.out.println("0) Save & Close");
        divScreen();
    }

    public static void marketMenu(int[] data){
        divScreen();
        info(data);
        divScreen();
        System.out.println("1) Buy...");
        System.out.println("2) Sell...");
        System.out.println("0) Go back");
    }

    /**
     *
     * @param data [currentDay, dueDay, currentCash, goalCash]
     * @param offer
     */
    public static void marketBuyMenu(int[] data, ArrayList<String>offer){
        divScreen();
        info(data);
        divScreen();
        System.out.println("1) " + offer.get(0));
        System.out.println("2) " + offer.get(1));
        System.out.println("3) " + offer.get(2));
        System.out.println("4) " + offer.get(3));
        System.out.println("0) Go back");
        divScreen();
    }

    public static void marketSellMenu(int[] data){
        divScreen();
        info(data);
        divScreen();
        System.out.println("");
        System.out.println("0) Go back");
    }

}
