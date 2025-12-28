package com.example.witch;



public class PlantCare extends GameAction {
    private static final String[] DESCRIPTIONS ={
            "Roślinki prawie usychają, trzeba o nie zadbać.",
            "Roślinki wymagają małej pielęgnacji.",
            "Roślinki są powoli gotowe do zbioru."
    };
    public PlantCare(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=8;

    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
