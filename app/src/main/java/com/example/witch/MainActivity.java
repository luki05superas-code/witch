package com.example.witch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton buttonClose;
    private GameModel gameModel;
    private ProgressBar energyBar;
    private ProgressBar timeBar;
    private ImageButton actionButt1;
    private ImageButton actionButt2;
    private GameAction actionMakePotion;
    private GameAction actionGoToFly;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        gameModel = new GameModel();
        actionMakePotion=new GameAction("Uważ eliksir",20,20);
        actionGoToFly= new GameAction("Idz na trening latania na miotle.", 20, 30);
        energyBar = findViewById(R.id.energy_bar);
        timeBar = findViewById(R.id.time_bar);
        actionButt1 = findViewById(R.id.button_wykrzyknik1);
        actionButt2 = findViewById(R.id.button_wykrzyknik2);
        buttonClose = (ImageButton) findViewById(R.id.button_close);
        energyBar.setMax(100);
        timeBar.setMax(100);
        actionButt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handleActionClick(actionMakePotion);
            }
        });
        actionButt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handleActionClick(actionGoToFly);
            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void handleActionClick(GameAction action){
        boolean success = gameModel.performAction(action.getEnergyCost(),action.getTimeCost());
        if(success){
            Toast.makeText(this, action.getDescription() + " wykonane!", Toast.LENGTH_SHORT).show();
            updateUI();
        } else {
            Toast.makeText(this, "Brak zasobów do wykonania: " + action.getDescription(), Toast.LENGTH_SHORT).show();
        }
    }
    private void updateUI() {
        energyBar.setProgress(gameModel.getCurrentEnergy());
        timeBar.setProgress(gameModel.getCurrentTime());
    }
}
