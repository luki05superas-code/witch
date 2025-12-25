package com.example.witch;

import java.util.Random;

public class FortuneTelling extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Poćwiczenie wróżenia przed egzaminem.",
            "Obiecane ciotce wywróżenie jak obfite deszcze będą w przyszłym miesiącu.",
            "Zajrzenie w przyszłość, aby dowiedzieć się czy będą białe święta Bożego Narodzenia."
    };
    public FortuneTelling(int timeCost, int energyCost){
        super(timeCost,energyCost);
        Random random = new Random();
        int index = random.nextInt(DESCRIPTIONS.length);
        this.description = DESCRIPTIONS[index];


    }
}
