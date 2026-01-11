package com.example.witch;


/** Klasa opisująca jedną z czynności do wykonania w grze */
public class Cleaning extends GameAction{
    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS={
            "Jest straszny bałagan w pokoju, nic nie można w nim znaleźć.",
            "W pokoju panuje artystyczny nieład, ale mógłby być większy porządek.",
            "Przydałoby się za niedługo umyć okna."
    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public Cleaning(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=6;

    }
/** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
