import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Player {
    int health, mana, gold;

    String name;

    private Map<String, Integer> equipment;

    public Player(String name, int health, int mana, int gold) {
        this.health = health;
        this.mana = mana;
        this.gold = gold;
        this.name = name;
        this.equipment = new HashMap<>();
    }

    public void addEquipment(String name, int cost){
        equipment.put(name, cost);
    }

    public Player() {
        health = 0;
        mana = 0;
        gold = 0;
    }



}