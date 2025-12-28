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
    private ImageButton actionButt3;
    private ImageButton actionButt4;
    private ImageButton actionButt5;
    private ImageButton actionButt6;
    private ImageButton actionButt7;
    private ImageButton actionButt8;
    private ImageButton replyaButt;
    private Button level1Button;
    private Button level2Button;
    private Button level3Button;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        gameModel = new GameModel(1);

        energyBar = findViewById(R.id.energy_bar);
        timeBar = findViewById(R.id.time_bar);
        actionButt1 = findViewById(R.id.button_wykrzyknik1);
        actionButt2 = findViewById(R.id.button_wykrzyknik2);
        actionButt3 = findViewById(R.id.button_wykrzyknik3);
        actionButt4 = findViewById(R.id.button_wykrzyknik4);
        actionButt5 = findViewById(R.id.button_wykrzyknik5);
        actionButt6 = findViewById(R.id.button_wykrzyknik6);
        actionButt7 = findViewById(R.id.button_wykrzyknik7);
        actionButt8 = findViewById(R.id.button_wykrzyknik8);
        replyaButt = findViewById(R.id.button_replay);
        buttonClose = (ImageButton) findViewById(R.id.button_close);
        level1Button = (Button) findViewById(R.id.button_poziom_1);
        level2Button = (Button) findViewById(R.id.button_poziom_2);
        level3Button = (Button) findViewById(R.id.button_poziom_3);

        energyBar.setMax(100);
        timeBar.setMax(100);
        refreshButtons();

        setupActionButtons();
        buttonClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        replyaButt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameModel.resetGame();
                updateUI();
            }
        });
        updateUI();


    }

    private void setupActionButtons(){
        GameAction action1 = gameModel.getAction("wykrzyknik1");
        if(action1 != null){
            actionButt1.setOnClickListener(view -> handleActionClick(action1));
        }
        GameAction action2 = gameModel.getAction("wykrzyknik2");
        if(action2 != null){
            actionButt2.setOnClickListener(view -> handleActionClick(action2));
        }
        GameAction action3 = gameModel.getAction("wykrzyknik3");
        if(action3 != null){
            actionButt3.setOnClickListener(view -> handleActionClick(action3));
        }
        GameAction action4 = gameModel.getAction("wykrzyknik4");
        if(action4 != null){
            actionButt4.setOnClickListener(view -> handleActionClick(action4));
        }
        GameAction action5 = gameModel.getAction("wykrzyknik5");
        if(action5 != null){
            actionButt5.setOnClickListener(view -> handleActionClick(action5));
        }
        GameAction action6 = gameModel.getAction("wykrzyknik6");
        if(action6 != null){
            actionButt6.setOnClickListener(view -> handleActionClick(action6));
        }
        GameAction action7 = gameModel.getAction("wykrzyknik7");
        if(action7 != null){
            actionButt7.setOnClickListener(view -> handleActionClick(action7));
        }
        GameAction action8 = gameModel.getAction("wykrzyknik8");
        if(action8 != null){
            actionButt8.setOnClickListener(view -> handleActionClick(action8));
        }


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
    private void setupButton(ImageButton btn, String key){
        GameAction action = gameModel.getAction(key);
        if(action != null){
            btn.setVisibility(View.VISIBLE);
        }
        else {
            btn.setVisibility(View.GONE);
        }

    }
    private void refreshButtons(){
        setupButton(actionButt1,"wykrzyknik1");
        setupButton(actionButt2,"wykrzyknik2");
        setupButton(actionButt3,"wykrzyknik3");
        setupButton(actionButt4,"wykrzyknik4");
        setupButton(actionButt5,"wykrzyknik5");
        setupButton(actionButt6,"wykrzyknik6");
        setupButton(actionButt7,"wykrzyknik7");
        setupButton(actionButt8,"wykrzyknik8");

    }
}
