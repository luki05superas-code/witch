package com.example.witch;

import java.util.Random;

public class GoingOut extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Wspólne spotkanie w celu nauki na najbliższy sprawdzian.",
            "Wyjście z nową koleżanką, która dopiero co wprowadziła się do miasta, żeby pokazać jej okolicę.",
            "Wspólne wyjście na miasto w celu zobaczenia co nowego jest w magicznych sklepach."
    };
    public GoingOut (int timeCost, int energyCost)
    {
        super(timeCost,energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];
    }
}
