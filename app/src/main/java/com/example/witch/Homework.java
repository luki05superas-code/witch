package com.example.witch;


/** Klasa opisująca jedną z czynności do wykonania w grze */
public class Homework extends GameAction {

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS = {
            "Jutro jest kartkówka, na którą konieczne jest powtórzenie materiału.",
            "Za tydzień jest sprawdzian z rzucania zaklęć, trzeba się do niego dobrze przygotować.",
            "Za tydzień trzeba oddać krótką pracę domową."
    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public Homework(int timeCost, int energyCost) {
        super(timeCost, energyCost);
        this.nr_butt=3;



    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }

}
