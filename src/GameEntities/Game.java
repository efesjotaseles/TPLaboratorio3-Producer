package GameEntities;

import Console.PrintConsole;

import java.util.Scanner;

public class Game {
    private GameState gameState;
    private Scanner scanner;

    public Game() {
        gameState = new GameState();
        scanner = new Scanner(System.in);
    }

    public void initGame(){
        int choice = -1;
        while (choice != 0) {
            PrintConsole.initMenu();
            choice = scanner.nextInt(); //Try
            switch (choice) {
                case 1:
                    //Continue previous game from saved json
                    break;
                case 2:
                    //Start new game from default json
                    break;

            }
        }
    }

    public void daylyGame(GameState gameState){
        int choice = -1;
        while (choice != 0){
            PrintConsole.dailyMenu(gameState.getDailyInfo(),gameState.getActions());
        }
    }
}
