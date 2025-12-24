package com.example.witch;

import java.util.Random;

public class MakePotion extends GameAction  {
    private static final String[] DESCRIPTIONS = {
     "Uwarz eliksir na jutrzejsze zajęcia.",
            "Uwarz eliksir na dobrą pamięć dla babci na prezent z okazji imienin, które ma w przyszłym tygodniu.",
            "Uwarz eliksiry na przyszło-miesięczny konkurs Najlepszy eliksir."

    };
    public MakePotion(int timeCost, int energyCost) {
        super(timeCost, energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];
    }
}
