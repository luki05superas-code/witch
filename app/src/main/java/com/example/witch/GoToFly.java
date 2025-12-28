package com.example.witch;

public class GoToFly extends GameAction {
    private static final String[] DESCRIPTIONS={
            "Ostatni trening przed zbliżającymi się zawodami.",
            "Musisz poćwiczyć technikę, aby na kolejny sezon dostać się do reprezentacji narodowej.",
            " Koleżanki z drużyny po ostatnich wygranych zawodach stwierdziły, że dla przyjemności lecą na Babią Górę."
    };
    public GoToFly(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=2;


    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
