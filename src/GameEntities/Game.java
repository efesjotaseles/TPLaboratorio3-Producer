package GameEntities;

import Console.PrintConsole;

import java.util.Scanner;

public class Game {
    private GameState gameState;
    private Market market;
    private Scanner scanner;

    public Game() {
        gameState = new GameState();
        market = new Market();
        scanner = new Scanner(System.in);
    }

    public void initGame(){
        int choice = -1;
        while (choice != 0) {
            PrintConsole.initMenu();
            choice = scanner.nextInt(); //Try
            switch (choice) {
                case 1:
                    market.renewOffer();
                    //Continue previous game from saved json
                    break;
                case 2:
                    market.renewOffer();
                    //Start new game from default json
                    break;

            }
        }
    }

    public void dailyGame(GameState gameState){
        int choice = -1;
        while (choice != 0){
            PrintConsole.dailyMenu(gameState.getDailyInfo(),gameState.getActions());
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    //Market
                    break;
                case 2:
                    //Fabricate
                    break;
                case 3:
                    //Manage machines
                    break;
                case 4:
                    //End the day
                    break;
                case 5:
                    //Pay debt!
                    break;
                case 0:
                    //Save gameState into JSON, and exit loop
                    break;
            }
        }
    }

    public void marketGame(GameState gameState){
        int choice = -1;
        while (choice != 0){
            PrintConsole.marketMenu(gameState.getDailyInfo());
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    //Buy menu
                    break;
                case 2:
                    //Sell menu
                    break;
                case 0:
                    //GOES BACK
                    break;
            }
        }
    }

    public void marketBuyGame(GameState gameState){

    }


}
