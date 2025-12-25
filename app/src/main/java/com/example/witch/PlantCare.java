package com.example.witch;

import java.util.Random;

public class PlantCare extends GameAction {
    private static final String[] DESCRIPTIONS ={
            "Roślinki prawie usychają, trzeba o nie zadbać.",
            "Roślinki wymagają małej pielęgnacji.",
            "Roślinki są powoli gotowe do zbioru."
    };
    public PlantCare(int timeCost, int energyCost){
        super(timeCost,energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];
    }
}
