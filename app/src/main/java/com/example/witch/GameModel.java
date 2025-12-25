package com.example.witch;

import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private int currentEnergy = 100;
    private int currentTime = 100;
    private Map<String, GameAction> actions = new HashMap<>();

    public int getCurrentEnergy(){
        return currentEnergy;
    }

    public int getCurrentTime() {
        return currentTime;
    }
    public boolean performAction(int energyCost, int timeCost){
        if (currentEnergy >= energyCost && currentTime >= timeCost) {
            currentEnergy -= energyCost;
            currentTime -= timeCost;
            return true;
        }
        return false;
    }
    public GameModel(){
        initializeActions();
    }
    // TODO: dodać opcje dla resetowania dla konkretnego poziomu, ewentualnie zmienic tak żeby odrazu ustawiało czynności.
    private void initializeActions(){
        actions.put("wykrzyknik1", new MakePotion(20,20));
        actions.put("wykrzyknik2", new GoToFly( 20, 30));
        actions.put("wykrzyknik3", new Homework(20,20));
        actions.put("wykrzyknik4", new GoingOut(30,10));
        actions.put("wykrzyknik5", new ReadBook(5,5));
        actions.put("wykrzyknik6", new Cleaning(5,10));
        actions.put("wykrzyknik7", new FortuneTelling(10,10));
        actions.put("wykrzyknik8", new PlantCare(10,10));

    }
    public GameAction getAction(String actionKey){
        return actions.get(actionKey);
    }
    public void resetGame(){
        currentEnergy=100;
        currentTime=100;
    }
}
