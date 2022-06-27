package json;

import ElementClasses.BaseMaterials.Metal;
import ElementClasses.BaseMaterials.Plastic;
import ElementClasses.BaseMaterials.Wood;
import ElementClasses.CompositeStuff.Machines.Machine;
import ElementClasses.Persons.Person;
import GameEntities.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class JSON_Manager {

    public void json_toBaseMaterials(Player player, JSONObject jobj){
        try {
            player.addBMaterials(new Wood(), jobj.getInt("Wood"));
            player.addBMaterials(new Plastic(), jobj.getInt("Plastic"));
            player.addBMaterials(new Metal(), jobj.getInt("Metal"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void json_toMachines(Player player, JSONArray jarray){
        Class c;
        Object o;
        String className;
        for(int i=0;i< jarray.length();i++){
            try {
                className = jarray.getString(i);
                c = Class.forName(className);
                o = c.getDeclaredConstructor().newInstance();

                Machine m = (Machine) o;
                player.addMachine(m);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void json_toCrew(Player player, JSONArray jarray){
        Class c;
        Object o;
        String className;

        for(int i=0;i< jarray.length();i++){
            try {
                className = jarray.getString(i);
                c = Class.forName(className);
                o = c.getDeclaredConstructor().newInstance();

                Person p = (Person) o;
                player.addPerson(p);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public Player json_toPlayer(JSONObject jobj){
        Player player = new Player();
        try {
            player.setCash(jobj.getInt("Cash"));
            json_toBaseMaterials(player,jobj.getJSONObject("baseMaterials"));
            json_toCrew(player,jobj.getJSONArray("Crew"));
            json_toMachines(player,jobj.getJSONArray("Machines"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return player;
    }
}
