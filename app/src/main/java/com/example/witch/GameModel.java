package com.example.witch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** Klasa reprezentująca stan gry.*/
public class GameModel {
    /** Zmienna określająca aktualnie dostępną energię w grze */
    private int currentEnergy = 80;
    /** Zmienna określająca aktualnie dostępny czas w grze. */
    private int currentTime = 80;
    /** Zmienna określająca aktualny poziom gry. */
    protected int level;
    /** Zmienna określająca liczbę wykonanych ruchów w grze przez gracza */
    private int countMove=0;
    /** Zmienna określająca aktualny wynik gry. */
    private int point=0;
    /** Zmienna wiążąca konkretną czynność klasy GameAction z nazwą przycisku za pomocą którego wykonuje się tę czynność.
     */
    private Map<String, GameAction> actions = new HashMap<>();
    // Łatwiej było ją zdefiniować jako osobną zmienną niż dodawać do HsahMap
    /** Zmienna reprezentująca czynność wykonania planu.*/
    public GameAction plan;

/** Konstruktor inicjalizujący stan gry,
 * @param level poziom gry.*/
    public GameModel(int level){
        this.level=level;
        initializeLevel();

    }
    /** Metoda zwracająca aktualną dostępną energię.
     * @return aktualnie dostępną energię w grze.*/
    public int getCurrentEnergy(){
        return currentEnergy;
    }
/** Metoda zwracająca aktualny dostępny czas.
 * @return aktualny dostępny czas w grze.*/
    public int getCurrentTime() {
        return currentTime;
    }
    /** Boolean sprawdzający czy można wykonać daną akcję, jeśli tak to wykonuje ją.
     * @param action obiekt klasy GameAction reprezentujący akcja do wykonania.
     * @return true jeśli akcja została wykonana, false jeśli nie.*/
    public boolean performAction(GameAction action){
        if (currentEnergy >= action.getEnergyCost() && currentTime >= action.getTimeCost()) {
            currentEnergy -= action.getEnergyCost();
            currentTime -= action.getTimeCost();;
            countMove++;
            int multiplier = (level ==1) ? 2 :3;
            if(countMove <= (action.getPriority()*multiplier) && countMove > ((action.getPriority()-1)*multiplier)){
                point+=10;
            }

            return true;
        }
        return false;
    }
    /** Boolean sprawdzający czy można wykonać akcję głaskania kota, jeśli tak to wykonuje ją.
     * @param blackCat akcja głaskania kota.
     * @return true jeśli akcja została wykonana, false jeśli nie.*/
    public boolean petCat(GameAction blackCat){
        if (currentTime>=blackCat.getTimeCost() && currentEnergy <= 80){
            currentTime-=blackCat.getTimeCost();
            currentEnergy-=blackCat.getEnergyCost();
            return true;

        }
        return false;

    }
    /** Metoda wykonująca aktywność "planowania", dodająca czas, poniewarz czas przypisany do tej czynności jest ujemny.
     * @param plan akcja planowania, obiekt klasy GameAction.
     */
    public void makePlan(GameAction plan){
        currentTime-=plan.getTimeCost();
        plan.done=true;
    }


/** Tworzenie aktywności na podstawie aktualnego poziomu gry,
 * w oparciu o numer poziomu  wybieranie odpowiedniej ilości aktywności,
 * przypisywanie nim w sposób losowy priorytetów za pomocą mieszania listy,
 * (tworzenie także specjalnych czynności jak głaskanie kota i planowanie, którym nie jest przypisywany priorytet),
 * dodawanie ich do mapy.*/
    private void initializeLevel(){
        actions.clear();
        List<GameAction> pool = new ArrayList<>();
        switch (level) {
            case 1: pool.add(new MakePotion(10,10));
                pool.add(new GoToFly(10,10));
                pool.add(new Homework(10,10));
                pool.add(new GoingOut(10,10));
                pool.add(new ReadBook(10,10));
                pool.add(new Cleaning(10,10));
                pool.add(new FortuneTelling(10,10));
                pool.add(new PlantCare(10,10));
                break;

            case 2: pool.add(new MakePotion(20,5));
                pool.add(new GoToFly(10,15));
                pool.add(new Homework(10,10));
                pool.add(new GoingOut(10,5));
                pool.add(new ReadBook(15,5));
                pool.add(new Cleaning(20,15));
                pool.add(new FortuneTelling(10,20));
                pool.add(new PlantCare(5,5));
            break;
            case 3: pool.add(new MakePotion(10,5));
                pool.add(new GoToFly(10,20));
                pool.add(new Homework(5,15));
                pool.add(new GoingOut(20,10));
                pool.add(new ReadBook(20,5));
                pool.add(new Cleaning(10,15));
                pool.add(new FortuneTelling(15,20));
                pool.add(new PlantCare(5,10));
            break;

        }
        Collections.shuffle(pool);
        int count = (level == 1) ? 6: 8;
        for (int i = 0; i < count; i++) {
            GameAction action = pool.get(i);
            int priority = (i % 3)+1;
            action.setPriority(priority);
            actions.put("wykrzyknik" + action.nr_butt, action);

        }
        BlackCat action = new BlackCat(5, -20);
        actions.put("serce", action);
        plan = new DailySchedule(-20, 0);





    }
    /** Metoda zwracająca akcję na podstawie podanego klucza.*/
    public GameAction getAction(String actionKey){
        return actions.get(actionKey);
    }
    /** Metoda resetująca stan gry na aktualnym poziomie.*/
    public void resetGame(){
        currentEnergy=80;
        currentTime=80;
        point=0;
        countMove=0;
        resetActions();
    }
    /** Metoda resetująca status wszystkich aktywności na false.*/
    public void resetActions(){
        for (GameAction action : actions.values()){
            action.done=false;
        }
        plan.done=false;
    }
    /** Metoda zwracająca aktualną ilość punktów.
     * @return point, aktualna ilość punktów.*/
    public int getPoint(){
        return point;
    }

    /** Metoda zwracająca opis wszystkich aktywności na stanie gry.
     * @return opis wszystkich aktywności wpisanych do HashMap na stanie gry.*/
    public String getAllDescription(){
        StringBuilder allDescription = new StringBuilder();
        allDescription.append("Czynności do wykonania:\n");
        for (GameAction action : actions.values()){
            if(action != null && action.getDescription()!=null){
                allDescription.append("- ")
                        .append(action.getDescription())
                        .append(" czas wykonania: ")
                        .append(action.getTimeCost())
                        .append(", energia: ")
                        .append(action.getEnergyCost())
                        .append("\n");
            }
        }
        return allDescription.toString();
    }
    /** Metoda zwracająca tekst zakończenia gry.
     * @param level aktualny poziom gry.
     * @return tekst zakończenia gry.*/
    public String win(int level){
        StringBuilder text = new StringBuilder();
        text.append("Gratulacje ukończenia poziomu.\n Twój wynik to: ")
                .append(point)
                .append(" punktów ");
        if(level==1){
            text.append("na 60 punktów możliwych do zdobycia.\n");

        }
        if(level==2 ||level==3){
            text.append("na 80 punktów możliwych do zdobycia.\n");}
        text.append("Możesz przejść jeszcze raz ten poziom lub wybrać inny poziom.\n");
        return text.toString();
    }
}
