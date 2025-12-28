package com.example.witch;



public class GoingOut extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Wspólne spotkanie w celu nauki na najbliższy sprawdzian.",
            "Wyjście z nową koleżanką, która dopiero co wprowadziła się do miasta, żeby pokazać jej okolicę.",
            "Wspólne wyjście na miasto w celu zobaczenia co nowego jest w magicznych sklepach."
    };
    public GoingOut (int timeCost, int energyCost)
    {
        super(timeCost,energyCost);
        this.nr_butt=4;

    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
