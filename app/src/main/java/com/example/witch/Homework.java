package com.example.witch;

import java.util.Random;

public class Homework extends GameAction {
    private static final String[] DESCRIPTIONS = {
            "Jutro jest kartkówka, na którą konieczne jest powtórzenie materiału.",
            "Za tydzień jest sprawdzian z rzucania zaklęć, trzeba się do niego dobrze przygotować.",
            "Za tydzień trzeba oddać krótką pracę domową."
    };
    public Homework(int timeCost, int energyCost) {
        super(timeCost, energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];

    }

}
