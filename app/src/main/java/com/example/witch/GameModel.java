package com.example.witch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModel {
    private int currentEnergy = 80;
    private int currentTime = 80;
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
    public GameModel(int level){
        initializeLevel(level);
    }
    // TODO: dodać opcje dla resetowania dla konkretnego poziomu, ewentualnie zmienic tak żeby odrazu ustawiało czynności.
    private void initializeLevel(int level){
        actions.clear();
        List<GameAction> pool = new ArrayList<>();
        switch (level) {
            case 1: pool.add(new MakePotion(10,10));
                pool.add(new GoToFly(10,10));
                pool.add(new Homework(10,10));
                pool.add(new GoingOut(10,10));
                pool.add(new ReadBook(10,10));
                pool.add(new Cleaning(10,10));
                pool.add(new FortuneTelling(10,10));
                pool.add(new PlantCare(10,10));
                break;

            case 2: pool.add(new MakePotion(20,5));
                pool.add(new GoToFly(10,15));
                pool.add(new Homework(10,10));
                pool.add(new GoingOut(10,5));
                pool.add(new ReadBook(15,5));
                pool.add(new Cleaning(20,15));
                pool.add(new FortuneTelling(10,20));
                pool.add(new PlantCare(5,5));
            break;
            case 3: pool.add(new MakePotion(10,5));
                pool.add(new GoToFly(10,20));
                pool.add(new Homework(5,15));
                pool.add(new GoingOut(20,10));
                pool.add(new ReadBook(20,5));
                pool.add(new Cleaning(10,15));
                pool.add(new FortuneTelling(15,20));
                pool.add(new PlantCare(5,10));
            break;

        }
        Collections.shuffle(pool);
        int count = (level == 1) ? 6: 8;
        for (int i = 0; i < count; i++) {
            GameAction action = pool.get(i);
            int priority = (i % 3)+1;
            action.setPriority(priority);
            actions.put("wykrzyknik" + action.nr_butt, action);

        }



    }
    public GameAction getAction(String actionKey){
        return actions.get(actionKey);
    }
    public void resetGame(){
        currentEnergy=80;
        currentTime=80;
    }
}
