package com.example.witch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModel {
    private int currentEnergy = 80;
    private int currentTime = 80;
    private int level;
    private int countMove=0;
    private int point=0;
    private Map<String, GameAction> actions = new HashMap<>();
    public GameAction plan;



    public int getCurrentEnergy(){
        return currentEnergy;
    }

    public int getCurrentTime() {
        return currentTime;
    }
    public boolean performAction(GameAction action){
        if (currentEnergy >= action.getEnergyCost() && currentTime >= action.getTimeCost()) {
            currentEnergy -= action.getEnergyCost();
            currentTime -= action.getTimeCost();;
            countMove++;
            int multiplier = (level ==1) ? 2 :3;
            if(countMove <= (action.getPriority()*multiplier) && countMove > ((action.getPriority()-1)*multiplier)){
                point+=10;
            }

            return true;
        }
        return false;
    }
    public void petCat(GameAction blackCat){
        if (currentTime>=blackCat.getTimeCost() && currentEnergy <= 80){
            currentTime-=blackCat.getTimeCost();
            currentEnergy-=blackCat.getEnergyCost();

        }

    }
    public void makePlan(GameAction plan){
        currentTime-=plan.getTimeCost();
        plan.done=true;
    }

    public GameModel(int level){
        this.level=level;
        initializeLevel();

    }

    private void initializeLevel(){
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
        BlackCat action = new BlackCat(5, -20);
        actions.put("serce", action);
        plan = new DailySchedule(-20, 0);





    }
    public GameAction getAction(String actionKey){
        return actions.get(actionKey);
    }
    public void resetGame(){
        currentEnergy=80;
        currentTime=80;
        point=0;
        countMove=0;
        resetActions();
    }
    public void resetActions(){
        for (GameAction action : actions.values()){
            action.done=false;
        }
        plan.done=false;
    }
    public int getPoint(){
        return point;
    }
    public int getCountMove(){
        return countMove;
    }
    public String getAllDescription(){
        StringBuilder allDescription = new StringBuilder();
        allDescription.append("Czynności do wykonania:\n");
        for (GameAction action : actions.values()){
            if(action != null && action.getDescription()!=null){
                allDescription.append("- ")
                        .append(action.getDescription())
                        .append(" czas wykonania: ")
                        .append(action.getTimeCost())
                        .append(", energia: ")
                        .append(action.getEnergyCost())
                        .append("\n");
            }
        }
        return allDescription.toString();
    }
}
