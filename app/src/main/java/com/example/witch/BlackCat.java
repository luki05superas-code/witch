package com.example.witch;

/** Klasa opisująca jedną z czynności do wykonania w grze */
public class BlackCat extends GameAction{
/** Konstruktor przyjmujący czas i energię potrzebne do wykonania czynności oraz ustawiający opis czynności. */
    public BlackCat(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.description="Miau, miau. Miauuu!!!";
    }
/** Metoda nie używana dla tej konkretnej klasy*/
    @Override
    public void updateDescription() {}

}
