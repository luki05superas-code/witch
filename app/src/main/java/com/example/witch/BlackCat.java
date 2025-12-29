package com.example.witch;

public class BlackCat extends GameAction{

    public BlackCat(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.description="Miau, miau. Miauuu!!!";
    }

    @Override
    public void updateDescription() {

    }

}
