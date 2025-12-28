package com.example.witch;

public abstract class GameAction {
    protected String description;
    protected int timeCost;
    protected int energyCost;
    protected int priority;
    public int nr_butt;

    public GameAction( int timeCost,int energyCost){

        this.energyCost=energyCost;
        this.timeCost=timeCost;
    }
    // Przypisywanie opisu czynności dopiero jak będzie ustalona priorytetowość
    public abstract void updateDescription();
    public void setPriority(int priority){
        this.priority=priority;
        updateDescription();
    }
    public int getPriority(){
        return priority;
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

