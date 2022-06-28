package Console;

import ElementClasses.Element;
import GameEntities.GameState;

import java.util.ArrayList;

public class PrintConsole {

    private static void divScreen(){
        System.out.println("--------------------------------------------------");
    }

    public static void initMenu(){
        divScreen();
        System.out.println("1) Continue Game");
        System.out.println("2) Start New Game");
        System.out.println("0) Exit");
        divScreen();
    }

    public static void dailyInfo(int[] info){
        System.out.println("Day: " + info[0] + " | Due Day: " + info[1]);
        System.out.println("Cash: " + info[2] + " | Goal: " + info[3]);

    }

    /**
     *
     * @param info [currentDay, dueDay, currentCash, goalCash]
     * @param actions [tradeActionsTaken, tradeActionsLimit, fabricateActionsTaken, fabricateActionsLimit]
     */
    public static void dailyMenu(int[] info, int[]actions){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("1) Market (" + actions[0] + "/" + actions[1] + ")");
        System.out.println("2) Fabricate (" + actions[2] + "/" + actions[3] + ")");
        System.out.println("3) Manage Machines [not available]");
        System.out.println("4) End the day");
        System.out.println("5) Pay debt!");
        System.out.println("0) Save & Close");
        divScreen();
    }

    public static void marketMenu(int[] info){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("1) Buy...");
        System.out.println("2) Sell...");
        System.out.println("0) Go back");
    }

    /**
     *
     * @param info [currentDay, dueDay, currentCash, goalCash]
     * @param offer
     */
    public static void marketBuyMenu(int[] info, Element[] offer){
        divScreen();
        dailyInfo(info);
        divScreen();
        String[] names = new String[4];
        int[] values = new int[4];
        for(int i=0;i<4;i++){
            if(offer[i] != null) {
                names[i] = offer[i].toString();
                values[i] = offer[i].getValue();
            }
            else{
                names[i] = "** no item **";
                values[i] = 0;
            }
        }
        int choice;
        for (int i=0;i<4;i++){
            choice = i+1;
            System.out.println(choice + ") " + names[i] + " ($ " + values[i]);
        }
        System.out.println("0) Go back");
        divScreen();
    }

    public static void buyConfirmation(int[] info , Element item){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("Sure to buy " + item.toString() + "?");
        System.out.println("Value: $" + item.getValue());
        System.out.println("1) YES!");
        System.out.println("0) No");
        divScreen();
    }

    public static void itemPurchased(int[] info, Element item){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println(item.toString() + "purchased!");
        divScreen();

    }

    public static void marketSellMenu(int[] info, int[] values){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("1) Sell all your production ($ " + values[0] + ")");
        System.out.println("2) Sell all your materials. ($ " + values[1] + ")");
        System.out.println("3) Sell all your machines. ($ " + values[2] + ")");
        System.out.println("0) Go back");
    }

    public static void sellEveryConfirmation(int[] info, String message , int value){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("Sure to sell every " + message + "?");
        System.out.println("Value: $ " + value);
        System.out.println("1) YES!");
        System.out.println("0) No.");
        divScreen();
    }

    public static void sellConfirmation(int[] info){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("Sale confirmed!!!");
        divScreen();
    }

    public static void fabricateMenu(int[] info, ArrayList<String> options){
        divScreen();
        dailyInfo(info);
        divScreen();
        if(options.size() > 0){
            for (int i=0;i<options.size();i++){
                int pos = i+1;
                System.out.println(pos + ") " + options.get(i));
            }
            System.out.println("0) Go back.");
        }
        else {
            System.out.println("Cannot fabricate anything!");
        }
        divScreen();
    }

    public static void payDebtMenu(GameState gameState){
        divScreen();
        dailyInfo(gameState.getDailyInfo());
        divScreen();
        if(gameState.getPlayer().getCash()< gameState.getGoalCash()){
            System.out.println("You don't have enough money to pay the debt....");
        }
        else {
            System.out.println("It seems you can pay your debt!");
            System.out.println("1) PAY DEBT NOW!!!");
            System.out.println("0) Not now...");
        }
        divScreen();
    }

    public static void winGame(int[] info){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("CONGRATULATIONS!!!!!");
        System.out.println("YOU PAYED YOUR DEBT!!!!");
        divScreen();
    }

    public static void pastDueDay(int[] info){
        divScreen();
        dailyInfo(info);
        divScreen();
        System.out.println("...you went beyond due day without paying your debt...");
        System.out.println("The Bank takes control of your factory :(");
        divScreen();
    }


}
