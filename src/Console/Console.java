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

    public static void dailyMenu(int[] data){
        divScreen();
        info(data);
        System.out.println();
    }

}
