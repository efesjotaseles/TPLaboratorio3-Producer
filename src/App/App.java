package App;



//import ElementClasses.BaseMaterials.Metal;

import Console.PrintConsole;
import ElementClasses.BaseMaterials.BaseMaterial;
import ElementClasses.BaseMaterials.Metal;
import ElementClasses.CompositeStuff.Furniture.MetalChair;
import ElementClasses.Element;
import GameEntities.Game;
import GameEntities.GameState;
import json.JSON_Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Game game = new Game();
        String jsonString = "{\n" +
                "  \"currentDay\" : 1,\n" +
                "  \"dueDay\" : 30,\n" +
                "  \"goalCash\" : 300,\n" +
                "  \"player\" : {\n" +
                "    \"cash\": 100,\n" +
                "    \"machines\" : [\"ElementClasses.CompositeStuff.Machines.F_WoodenChair\"],\n" +
                "    \"crew\" : [\"ElementClasses.Persons.Worker\",\"ElementClasses.Persons.Merchant\"],\n" +
                "    \"baseMaterials\" : {\n" +
                "      \"Wood\" : 5,\n" +
                "      \"Plastic\" : 0,\n" +
                "      \"Metal\" : 3\n" +
                "    }\n" +
                "  }\n" +
                "}";

        JSONObject jobj;
        try {
            jobj = new JSONObject(jsonString);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JSON_Manager json_manager = new JSON_Manager();
        GameState gameState = json_manager.json_toGameState(jobj);
        PrintConsole.dailyInfo(gameState.getDailyInfo());


    }
}
