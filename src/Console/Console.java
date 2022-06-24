package Console;

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
        System.out.println("1) Market (" + tradeActions[0] + "/" + tradeActions[1] + ")");
        System.out.println("2) Fabricate (" + fabricateActions[0] + "/" + fabricateActions[1] + ")");
        System.out.println("3) Manage Machines");
        System.out.println("4) End the day");
        System.out.println("5) Pay debt!");
        System.out.println("0) Save & Close");
    }

    public static void marketMenu()

}
