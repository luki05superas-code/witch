package com.example.witch;


/** Klasa opisująca jedną z czynności do wykonania w grze */
public class PlantCare extends GameAction {

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS ={
            "Roślinki prawie usychają, trzeba o nie zadbać.",
            "Roślinki wymagają niewielkiej pielęgnacji.",
            "Roślinki są powoli gotowe do zbioru."
    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public PlantCare(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=8;

    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
