package com.example.witch;
import java.util.Random;
public class ReadBook extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Jest do przeczytania lektura na przyszły tydzień na lekcje literatury.",
            "Na półce czeka wypożyczona książka z biblioteki o historii magicznych królestw.",
            "Świeżo wydana książka najlepszej pisarki kryminalnej wzywa do czytania."
    };
    public ReadBook(int timeCost, int energyCost){
        super(timeCost,energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];

    }
}
