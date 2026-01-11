package com.example.witch;


/** Klasa opisująca jedną z czynności do wykonania w grze */
public class MakePotion extends GameAction  {

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS = {
     "Uwarz eliksir na jutrzejsze zajęcia.",
            "Uwarz eliksir na dobrą pamięć dla babci jako prezent z okazji jej imienin, które ma w przyszłym tygodniu.",
            "Uwarz eliksiry na przyszło-miesięczny konkurs Najlepszy Eliksir."

    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public MakePotion(int timeCost, int energyCost) {
        super(timeCost, energyCost);
        this.nr_butt=1;


    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
