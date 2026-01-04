package com.example.witch;


/** Klasa opisująca jedną z czynności do wykonania w grze */
public class GoingOut extends GameAction{

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS={
            "Wspólne spotkanie w celu nauki na najbliższy sprawdzian.",
            "Wyjście z nową koleżanką, która dopiero co wprowadziła się do miasta, żeby pokazać jej okolicę.",
            "Wspólne wyjście na miasto w celu zobaczenia co nowego jest w magicznych sklepach."
    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public GoingOut (int timeCost, int energyCost)
    {
        super(timeCost,energyCost);
        this.nr_butt=4;

    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
