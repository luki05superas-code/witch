package com.example.witch;

/** Klasa opisująca jedną z czynności do wykonania w grze */
public class DailySchedule extends GameAction{
    /** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności */
    public DailySchedule(int timeCost, int energyCost){
        super(timeCost,energyCost);

    }
/** Metoda nie używana dla tej konkretnej klasy*/
    @Override
    public void updateDescription() {}
}
