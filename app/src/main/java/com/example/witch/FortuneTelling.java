package com.example.witch;



public class FortuneTelling extends GameAction{
    private static final String[] DESCRIPTIONS={
            "Poćwiczenie wróżenia przed egzaminem.",
            "Obiecane ciotce wywróżenie jak obfite deszcze będą w przyszłym miesiącu.",
            "Zajrzenie w przyszłość, aby dowiedzieć się czy będą białe święta Bożego Narodzenia."
    };
    public FortuneTelling(int timeCost, int energyCost){
        super(timeCost,energyCost);
        this.nr_butt=7;



    }

    @Override
    public void updateDescription() {
        if (this.priority >= 1 && this.priority <= 3){
            this.description = DESCRIPTIONS[this.priority - 1];
        }
    }
}
