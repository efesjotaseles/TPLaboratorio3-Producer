package GameEntities;

import Console.PrintConsole;
import ElementClasses.Element;
import json.JSON_Manager;
import json.JsonUtiles;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Game {
    private GameState gameState;
    private Market market;
    private Scanner scanner;
    private JSON_Manager json_manager;
    JSONObject jobj;

    public Game() {
        gameState = new GameState();
        market = new Market();
        scanner = new Scanner(System.in);
        json_manager = new JSON_Manager();
        jobj = new JSONObject();
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
                    try {
                        jobj = new JSONObject(JsonUtiles.leer("saveSlot1.json"));
                        gameState = json_manager.json_toGameState(jobj);
                        dailyGame(gameState);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 2:
                    market.renewOffer();
                    //Start new game from default json
                    try {
                        jobj = new JSONObject(JsonUtiles.leer("defaultGameState.json"));
                        gameState = json_manager.json_toGameState(jobj);
                        dailyGame(gameState);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    break;

            }
            if(choice != 0){
                choice = -1;
            }
        }
    }

    //Consider to remove the parameters of gameState, since its a Class attribute
    public void dailyGame(GameState gameState){
        int choice = -1;
        while (choice != 0){
            PrintConsole.dailyMenu(gameState.getDailyInfo(),gameState.getActions());
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    marketGame(gameState);
                    break;
                case 2:
                    fabricateGame(gameState);
                    break;
                case 3:
                    //Manage machines
                    break;
                case 4:
                    //End the day
                    gameState.finishDay();
                    if(gameState.getCurrentDay()> gameState.getDueDay()){
                        //Bank takes the factory!
                        PrintConsole.pastDueDay(gameState.getDailyInfo());
                        choice = 0;
                    }
                    break;
                case 5:
                    //Pay debt!
                    payDebtGame(gameState);
                    break;
                case 0:
                    //Save gameState into JSON, and exit loop
                    jobj = json_manager.gameState_toJSON(gameState);
                    JsonUtiles.grabar(jobj,"saveSlot1.json");
                    break;
            }
            if (choice != 0){
                choice = -1;
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
                    marketBuyGame(gameState);
                    break;
                case 2:
                    marketSellGame(gameState);
                    break;
            }
            if(choice != 0) {
                choice=-1;
            }
        }
    }

    public void marketBuyGame(GameState gameState){
        int choice = -1;
        while (choice != 0){
            PrintConsole.marketBuyMenu(gameState.getDailyInfo(), market.getOffer());
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    if(market.getMaterialA() != null){
                        if(confirmBuyChoice(gameState,market.getMaterialA())){
                            //As is now, it prints the daily info previous to perform the purchase.
                            //TODO Perform the itemPurchased() with the updated info
                            PrintConsole.itemPurchased(gameState.getDailyInfo(),market.getMaterialA());
                            gameState.tradeOperation(gameState.getPlayer(),market, market.getMaterialA());
                        }
                    }
                    break;

                case 2:
                    if(market.getMaterialB() != null){
                        if(confirmBuyChoice(gameState,market.getMaterialB())){
                            //As is now, it prints the daily info previous to perform the purchase.
                            //TODO Perform the itemPurchased() with the updated info
                            PrintConsole.itemPurchased(gameState.getDailyInfo(), market.getMaterialB());
                            gameState.tradeOperation(gameState.getPlayer(),market,market.getMaterialB());
                        }
                    }
                    break;

                case 3:
                    if(market.getMachine() != null){
                        if(confirmBuyChoice(gameState,market.getMachine())){
                            //As is now, it prints the daily info previous to perform the purchase.
                            //TODO Perform the itemPurchased() with the updated info
                            PrintConsole.itemPurchased(gameState.getDailyInfo(), market.getMachine());
                            gameState.tradeOperation(gameState.getPlayer(),market,market.getMachine());
                        }
                    }
                    break;

                case 4:
                    if(market.getPerson() != null){
                        if(confirmBuyChoice(gameState,market.getPerson())){
                            //As is now, it prints the daily info previous to perform the purchase.
                            //TODO Perform the itemPurchased() with the updated info
                            PrintConsole.itemPurchased(gameState.getDailyInfo(), market.getPerson());
                            gameState.tradeOperation(gameState.getPlayer(),market,market.getPerson());
                        }
                    }
                    break;
            }
            if(choice != 0){
                choice = -1;
            }
        }


    }

    /**
     *
     * @return true if user confirms choice
     */
    private boolean confirmBuyChoice(GameState gameState, Element chosenElement){
        int choice = -1;
        boolean response = false;
        while (choice == -1){
            PrintConsole.buyConfirmation(gameState.getDailyInfo(), chosenElement);
            choice = scanner.nextInt();
            if (choice == 1){
                response = true;
            }
            else if(choice != 0){
                choice = -1;
            }
        }
        return response;
    }

    public void marketSellGame(GameState gameState){
        //For simplicity sake, for now the options will be to sell every stuff on inventory
        int choice = -1;
        while (choice != 0){
            PrintConsole.marketSellMenu(gameState.getDailyInfo(), gameState.playerValues());
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    if(gameState.playerStuffValue() > 0){
                        if(confirmSellEveryStuff(gameState)){
                            gameState.playerSellEveryStuff();
                            PrintConsole.sellConfirmation(gameState.getDailyInfo());
                        }
                    }
                    break;
                case 2:
                    //2) Sell all your base materials
                    break;
                case 3:
                    //3) Sell all your machines
                    break;
            }
            if(choice != 0){
                choice = -1;
            }
        }
    }

    private boolean confirmSellEveryStuff(GameState gameState){
        int choice = -1;
        boolean response = false;
        while (choice == -1){
            PrintConsole.sellEveryConfirmation(gameState.getDailyInfo(), "Stuff", gameState.playerStuffValue());
            choice = scanner.nextInt();
            if (choice == 1){
                response = true;
            }
            else if(choice != 0){
                choice = -1;
            }
        }
        return response;
    }

    private void fabricateGame(GameState gameState){
        int choice = -1;
        while (choice == -1){
            PrintConsole.fabricateMenu(gameState.getDailyInfo(), gameState.playerFabricateOptions());
            choice = scanner.nextInt();
            //NEW ISSUES
            //How to make an adaptative options with this design....???
            if(choice != 0){
                gameState.playerFabricate(choice);
                choice = -1;
            }
        }
    }

    private void payDebtGame(GameState gameState){
        int choice = -1;
        while (choice != 0){
            PrintConsole.payDebtMenu(gameState);
            if(gameState.getPlayer().getCash()>=gameState.getGoalCash()){
                choice = scanner.nextInt();
                if (choice == 1){
                    //pay debt
                    gameState.getPlayer().setCash(gameState.getPlayer().getCash()-gameState.getGoalCash());
                    PrintConsole.winGame(gameState.getDailyInfo());
                    choice = 0;
                }
                else if(choice != 0){
                    choice = -1;
                }
            }
            else{
                choice = 0;
            }
        }
    }


}
