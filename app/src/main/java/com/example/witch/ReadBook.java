package com.example.witch;

/** Klasa opisująca jedną z czynności do wykonania w grze */
public class ReadBook extends GameAction{

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS={
            "Jest do przeczytania lektura na przyszły tydzień na lekcję literatury.",
            "Na półce czeka wypożyczona książka z biblioteki o Historii Magicznych Królestw.",
            "Świeżo wydana książka najlepszej pisarki kryminalnej oczekuje na przeczytanie."
    };
    public ReadBook(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=5;



    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
