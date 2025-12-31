package com.example.witch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    private ImageButton heart;
    private ImageButton[] buttons;
    private TextView textPoint;
    LinearLayout overlayPanel;
    TextView overlayText;
    Button closeOverlayButton;
    Button planButton;




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        gameModel = new GameModel(1);

        energyBar = findViewById(R.id.energy_bar);
        timeBar = findViewById(R.id.time_bar);
        textPoint = findViewById(R.id.textPoint);
        actionButt1 = findViewById(R.id.button_wykrzyknik1);
        actionButt2 = findViewById(R.id.button_wykrzyknik2);
        actionButt3 = findViewById(R.id.button_wykrzyknik3);
        actionButt4 = findViewById(R.id.button_wykrzyknik4);
        actionButt5 = findViewById(R.id.button_wykrzyknik5);
        actionButt6 = findViewById(R.id.button_wykrzyknik6);
        actionButt7 = findViewById(R.id.button_wykrzyknik7);
        actionButt8 = findViewById(R.id.button_wykrzyknik8);
        buttons = new ImageButton[]{actionButt1, actionButt2, actionButt3, actionButt4, actionButt5, actionButt6, actionButt7, actionButt8};
        replyaButt = findViewById(R.id.button_replay);
        buttonClose = (ImageButton) findViewById(R.id.button_close);
        level1Button = (Button) findViewById(R.id.button_poziom_1);
        level2Button = (Button) findViewById(R.id.button_poziom_2);
        level3Button = (Button) findViewById(R.id.button_poziom_3);
        heart = findViewById(R.id.button_serce);
        overlayPanel = findViewById(R.id.overlayPanel);
        overlayText = findViewById(R.id.overlayText);
        closeOverlayButton = findViewById(R.id.closeOverlayButton);
        planButton = findViewById(R.id.button_plan);


        energyBar.setMax(100);
        timeBar.setMax(100);
        setupButtons();
        level1Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#62FDBA")));



       heart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String key = "serce";
                GameAction action = gameModel.getAction(key);
                if(action != null){

                    Toast.makeText(MainActivity.this, "Wykonałaś: " + action.getDescription() ,Toast.LENGTH_SHORT).show();
                    gameModel.petCat(action);
                    updateUI();
                    checkGameOver();
                }
                else{
                    Toast.makeText(MainActivity.this, "Błąd...", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        replyaButt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameModel.resetGame();
                setupButtons();
                updateUI();
            }
        });
        level1Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameModel = new GameModel(1);
                setupButtons();
                level1Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#62FDBA")));
                level2Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E92BA3")));
                level3Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E92BA3")));

                updateUI();

            }
        });
        level2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameModel = new GameModel(2);
                setupButtons();
                level2Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#62FDBA")));
                level1Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E92BA3")));
                level3Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E92BA3")));

                updateUI();
            }
        });
        level3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameModel = new GameModel(3);
                setupButtons();
                level3Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#62FDBA")));
                level2Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E92BA3")));
                level1Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E92BA3")));

                updateUI();
            }
        });
        closeOverlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overlayPanel.setVisibility(View.GONE); // Ukrywamy panel
            }
        });
        planButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = gameModel.getAllDescription();
                overlayText.setText(description);
                overlayPanel.setVisibility(View.VISIBLE); // Pokazujemy panel
                if(!gameModel.plan.done){
                    gameModel.makePlan(gameModel.plan);
                    updateUI();

                }
            }
        });




        updateUI();


    }


    private void handleActionClick(GameAction action){
        boolean success = gameModel.performAction(action);
        if(success){
            Toast.makeText(this, action.getDescription() + " wykonane!", Toast.LENGTH_SHORT).show();
            action.done=true;
            setupButtons();
            updateUI();
            checkGameOver();
        } else {
            Toast.makeText(this, "Brak zasobów do wykonania: " + action.getDescription(), Toast.LENGTH_SHORT).show();
        }
    }
    private void updateUI() {
        energyBar.setProgress(gameModel.getCurrentEnergy());
        timeBar.setProgress(gameModel.getCurrentTime());
        textPoint.setText("PUNKTY: " + gameModel.getPoint());


    }
    private void checkGameOver(){
        if(actionButt1.getVisibility() == View.GONE && actionButt2.getVisibility() == View.GONE && actionButt3.getVisibility() == View.GONE &&
                actionButt4.getVisibility() == View.GONE && actionButt5.getVisibility() == View.GONE && actionButt6.getVisibility() == View.GONE &&
                actionButt7.getVisibility() == View.GONE && actionButt8.getVisibility() == View.GONE){
            String text = gameModel.win(gameModel.level);
            overlayText.setText(text);
            overlayPanel.setVisibility(View.VISIBLE);

        }
        else if(gameModel.getCurrentTime()==0 && gameModel.plan.done){
            overlayText.setText("Nie masz już zasobów na wykonywanie czynności. Spróbuj jeszcze raz.");
            overlayPanel.setVisibility(View.VISIBLE);
            gameModel.resetGame();
            setupButtons();
            updateUI();
        }
    }
    private void setupButtons(){
        for(int i=0; i<buttons.length; i++){
            ImageButton btn = buttons[i];
            String key = "wykrzyknik" + (i+1);

            GameAction action = gameModel.getAction(key);

            if(action != null && !action.done){
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(view -> handleActionClick(action));
            }
            else {
                btn.setVisibility(View.GONE);
            }
        }



    }

}
