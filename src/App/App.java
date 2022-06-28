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
import json.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Game game = new Game();
        game.initGame();







    }
}
