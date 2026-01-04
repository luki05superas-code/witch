package com.example.witch;
/** Klasa opisująca jedną z czynności do wykonania w grze */
public class GoToFly extends GameAction {

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS={
            "Ostatni trening przed zbliżającymi się zawodami.",
            "Musisz poćwiczyć technikę, aby na kolejny sezon dostać się do reprezentacji narodowej.",
            " Koleżanki z drużyny po ostatnich wygranych zawodach stwierdziły, że dla przyjemności lecą na Babią Górę."
    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public GoToFly(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=2;


    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
