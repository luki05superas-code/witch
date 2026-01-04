package com.example.witch;


/** Klasa opisująca jedną z czynności do wykonania w grze */
public class FortuneTelling extends GameAction{

    /** tablica z opisami czynności, po nadaniu priorytetu przypisywanay jest odpowiedni opis z tej tablicy */
    private static final String[] DESCRIPTIONS={
            "Poćwiczenie wróżenia przed egzaminem.",
            "Obiecane ciotce wywróżenie jak obfite deszcze będą w przyszłym miesiącu.",
            "Zajrzenie w przyszłość, aby dowiedzieć się czy będą białe święta Bożego Narodzenia."
    };
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności i przypisujący jej nr przycisku.*/
    public FortuneTelling(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=7;



    }
    /** Metoda aktualizująca opis czynności.*/
    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
