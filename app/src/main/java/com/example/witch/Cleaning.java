package com.example.witch;

import java.util.Random;

public class Cleaning extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Jest straszny bałagan w pokoju, nic nie można w nim znaleźć.",
            "W pokoju panuje artystyczny nie ład, ale mógłby być większy porządek.",
            "Przydałoby się za niedługo umyć okna. "
    };
    public Cleaning(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=6;
       // Random random = new Random();
       // int index = random.nextInt(DESCRIPTIONS.length);
       // this.description = DESCRIPTIONS[index];

    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
