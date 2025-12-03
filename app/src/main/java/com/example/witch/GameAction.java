package com.example.witch;

public class GameAction {
    private String description;
    private int timeCost;
    private int energyCost;
    public GameAction(String description, int timeCost,int energyCost){
        this.description=description;
        this.energyCost=energyCost;
        this.timeCost=timeCost;
    }
    public String getDescription(){
        return description;
    }
    public int getTimeCost(){
        return timeCost;
    }
    public int getEnergyCost(){
        return energyCost;
    }
}
