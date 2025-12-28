package com.example.witch;



public class Homework extends GameAction {
    private static final String[] DESCRIPTIONS = {
            "Jutro jest kartkówka, na którą konieczne jest powtórzenie materiału.",
            "Za tydzień jest sprawdzian z rzucania zaklęć, trzeba się do niego dobrze przygotować.",
            "Za tydzień trzeba oddać krótką pracę domową."
    };
    public Homework(int timeCost, int energyCost) {
        super(timeCost, energyCost);
        this.nr_butt=3;



    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }

}
