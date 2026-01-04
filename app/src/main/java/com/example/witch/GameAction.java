package com.example.witch;
/** Klasa abstrakcyjna reprezentująca czynności do wykonania w grze.*/
public abstract class GameAction {
    /** Zmienna opisująca czynność, na jej podstawie gracz ma określić priorytetowość czynności, czyli kiedy ją wykonać. */
    protected String description;
    /** Zmienna określająca ile czasu z paska czasu zabierze wykonanie czynności */
    protected int timeCost;
    /** Zmienna określająca ile energii z paska energii zabierze wykonanie czynności */
    protected int energyCost;
    /** Zmienna określająca priorytetowość czynności */
    protected int priority;
    /** Zmienna określająca jaki przycisk odpowiada danej czynności */
    public int nr_butt;
    /** Zmienna określająca czy czynność została już wykonana */
    public boolean done=false;

/** Konstruktor przyjmujący:
 * @param timeCost czas potrzebny do wykonania czynności
 * @param energyCost energia potrzebna do wykonania czynności

 */
    public GameAction( int timeCost,int energyCost){

        this.energyCost=energyCost;
        this.timeCost=timeCost;
    }
    // Przypisywanie opisu czynności dopiero jak będzie ustalona priorytetowość
    /** Metoda aktualizująca opis czynności.*/
    public abstract void updateDescription();
   /** Metoda ustawiająca priorytetowość czynności.*/
    public void setPriority(int priority){
        this.priority=priority;
        updateDescription();
    }
    /** Metoda zwracająca priorytetowość czynności.*/
    public int getPriority(){
        return priority;
    }
    /** Metoda zwracająca opis czynności.*/
    public String getDescription(){
        return description;
    }
    /** Metoda zwracająca czas potrzebny do wykonania czynności.*/
    public int getTimeCost(){
        return timeCost;
    }
    /** Metoda zwracająca energię potrzebne do wykonania czynności.*/
    public int getEnergyCost(){
        return energyCost;
    }
}

