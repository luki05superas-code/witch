package com.example.witch;
import java.util.Random;
public class GoToFly extends GameAction {
    private static final String[] DESCRIPTIONS={
            "Ostatni trening przed zbliżającymi się zawodami.",
            "Musisz poćwiczyć technikę, aby na kolejny sezon dostać się do reprezentacji narodowej.",
            " Koleżanki z drużyny po ostatnich wygranych zawodach stwierdziły, że dla przyjemności lecą na Babią Górę."
    };
    public GoToFly(int timeCost, int energyCost){
        super(timeCost,energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];
    }
}
