package com.example.witch;

public class GameModel {
    private int currentEnergy = 100;
    private int currentTime = 100;
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
    // TODO: dodać opcje dla resetowania dla konkretnego poziomu, ewentualnie zmienic tak żeby odrazu ustawiało czynności.
    public void resetGame(){
        currentEnergy=100;
        currentTime=100;
    }
}
