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
/** Klasa reprezentująca ekran gry (Activity).
 * Zarządza interfejsem użytkownika, obsługuje zdarzenia kliknięcia
 * oraz komunikuje się z modelem gry (GameModel).*/
public class MainActivity extends AppCompatActivity {
    /** Model gry, reprezentujący także aktualny stan gry */
    private GameModel gameModel;
    /** progres bar pokazujący dostępną energię, maksymalna wartość to 100, minimalna to 0 */
    private ProgressBar energyBar;
    /** pole tekstowe na wypisanie dostępnej energi */
    private TextView textEnergy;
    /** progres bar pokazujący dostępny czas, maksymalna wartość to 100, minimalna to 0 */
    private ProgressBar timeBar;
    /** pole tekstowe na wypisanie dostępnego czasu */
    private TextView textTime;
    /** Przycisk zamykający grę */
    private ImageButton buttonClose;
    /** Przyciski reprezentujące poszczególne czynności do wykonania */
    private ImageButton actionButt1;
    private ImageButton actionButt2;
    private ImageButton actionButt3;
    private ImageButton actionButt4;
    private ImageButton actionButt5;
    private ImageButton actionButt6;
    private ImageButton actionButt7;
    private ImageButton actionButt8;
    private ImageButton heart;
    private Button planButton;

    /** Tablica przycisków reprezentujących poszczególne czynności do wykonania, znajdują się w niej tylko te, które są dostępne i są to actionButtX  */
    private ImageButton[] buttons;
    /** Przycisk do przejścia do 1 poziomu. */
    private Button level1Button;
    /** Przycisk do przejścia do 2 poziomu. */
    private Button level2Button;
    /** Przycisk do przejścia do 3 poziomu. */
    private Button level3Button;
    /** Przycisk do replayu gry, z takimi samym GameModel. */
    private ImageButton replyaButt;

    /** Tekst wyświetlający aktualny wynik gry. */
    private TextView textPoint;
    /** Panel do wyświetlania planu dnia, ale także powitania gracza, informacji o zakończeniu rozgrywki.
     * Wyświetlany nad głównym interfejsem gry. */
    private LinearLayout overlayPanel;
    /** Pole tekstowe wewnątrz panelu slużące do wyświetlania komuikatów. */
    private TextView overlayText;
    /** Przycisk zamykający panel. */
    private Button closeOverlayButton;





    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        gameModel = new GameModel(1);

        energyBar = findViewById(R.id.energy_bar);
        timeBar = findViewById(R.id.time_bar);
        textEnergy = findViewById(R.id.textEnergy);
        textTime = findViewById(R.id.textTime);
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
        buttonClose = findViewById(R.id.button_close);
        level1Button = findViewById(R.id.button_poziom_1);
        level2Button = findViewById(R.id.button_poziom_2);
        level3Button = findViewById(R.id.button_poziom_3);
        heart = findViewById(R.id.button_serce);
        overlayPanel = findViewById(R.id.overlayPanel);
        overlayText = findViewById(R.id.overlayText);
        closeOverlayButton = findViewById(R.id.closeOverlayButton);
        planButton = findViewById(R.id.button_plan);


        energyBar.setMax(100);
        timeBar.setMax(100);
        setupButtons();
        level1Button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#62FDBA")));
        hello();




       heart.setOnClickListener(new View.OnClickListener() {
           // Obsługa kliknięcia przycisku serce
            public void onClick(View v) {

                GameAction action = gameModel.blackCat;
                boolean success = gameModel.petCat(action);
                if(success){

                    Toast.makeText(MainActivity.this,  action.getDescription() ,Toast.LENGTH_SHORT).show();
                    updateUI();
                    checkGameOver();
                }
                else{
                    Toast.makeText(MainActivity.this, "Za mało dostępnego czasu lub nie możesz zdobyć więcej energi.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            // Obsługa kliknięcia przycisku X (wyjścia z gry)
            public void onClick(View v) {
                finish();
            }
        });

        replyaButt.setOnClickListener(new View.OnClickListener() {
            // Obsługa kliknięcia przycisku Replay (reset aktualnego poziomu)
            public void onClick(View v) {
                gameModel.resetGame();
                setupButtons();
                updateUI();
            }
        });
        level1Button.setOnClickListener(new View.OnClickListener() {
           // Obsługa kliknięcia przycisku poziom 1, zmiany kolorów przycisków i ustawienie nowego poziomu gry
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
            // Obsługa kliknięcia przycisku poziom 2, zmiany kolorów przycisków i ustawienie nowego poziomu gry
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
            // Obsługa kliknięcia przycisku poziom 3, zmiany kolorów przycisków i ustawienie nowego poziomu gry
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
            // Obsługa kliknięcia przycisku zamykającego panel
            public void onClick(View v) {
                overlayPanel.setVisibility(View.GONE); // Ukrywamy panel
                closeOverlayButton.setText("ZAMKNIJ");
            }
        });
        planButton.setOnClickListener(new View.OnClickListener() {
           // Obsługa kliknięcia przycisku planu, który pokazuje plan na panelu
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
    private void hello (){
        String text ="Miło Cię widzieć osobo!!!\n Czy tak jak nasza młoda czarownica masz problem z planowaniem?\n " +
                "Jeśli tak to mamy nadzieję, że tak gra choć trochę Ci pomoże " +
                "w lepszym rozplanowaniu, co jest ważne i trzeba to zrobić jak najszybciej, a co może poczekać.\n" +
                "W PLANIE DNIA znajdziesz opisy czynności do wykonania. Zastanów się, co jest najważniejsze do zrobienia, a co mniej ważne, wykonaj w tej kolejności czynności.";
        String textBut= "ZAGRAJ";
        overlayText.setText(text);
        closeOverlayButton.setText(textBut);
        overlayPanel.setVisibility(View.VISIBLE);
    }

/** Obsługa kliknięcia przycisku wykrzyknika */
    private void handleActionClick(GameAction action){
        boolean success = gameModel.performAction(action);
        if(success){
            Toast.makeText(this, action.getDescription() + " Wykonane!", Toast.LENGTH_SHORT).show();
            action.done=true;
            setupButtons();
            updateUI();
            checkGameOver();
        } else {
            Toast.makeText(this, "Brak zasobów do wykonania: " + action.getDescription(), Toast.LENGTH_SHORT).show();
        }
    }

    /** Aktualizacja pasków energii i czasu oraz wyświetlanych punktów */
    private void updateUI() {

        energyBar.setProgress(gameModel.getCurrentEnergy());
        textEnergy.setText(getString(R.string.energy_lable, gameModel.getCurrentEnergy()));
        timeBar.setProgress(gameModel.getCurrentTime());
        textTime.setText(getString(R.string.time_lable, gameModel.getCurrentTime()));
        textPoint.setText(getString(R.string.point_lable, gameModel.getPoint()));


    }

    /** Sprawdzenie, czy poziom została zakończony i wyświetlenie odpowiedniego komunikatu */
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
    /** Ustawienie odpowiednich parametrów widoczności przycisków wykrzykników na podstawie ich statusu */
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
