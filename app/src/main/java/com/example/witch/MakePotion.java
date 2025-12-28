package com.example.witch;



public class MakePotion extends GameAction  {
    private static final String[] DESCRIPTIONS = {
     "Uwarz eliksir na jutrzejsze zajęcia.",
            "Uwarz eliksir na dobrą pamięć dla babci na prezent z okazji imienin, które ma w przyszłym tygodniu.",
            "Uwarz eliksiry na przyszło-miesięczny konkurs Najlepszy eliksir."

    };
    public MakePotion(int timeCost, int energyCost) {
        super(timeCost, energyCost);
        this.nr_butt=1;


    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
