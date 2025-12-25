package com.example.witch;

public abstract class GameAction {
    protected String description;
    protected int timeCost;
    protected int energyCost;
    public GameAction( int timeCost,int energyCost){

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

