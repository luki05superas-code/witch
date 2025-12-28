package com.example.witch;

public class ReadBook extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Jest do przeczytania lektura na przyszły tydzień na lekcje literatury.",
            "Na półce czeka wypożyczona książka z biblioteki o historii magicznych królestw.",
            "Świeżo wydana książka najlepszej pisarki kryminalnej wzywa do czytania."
    };
    public ReadBook(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=5;



    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
