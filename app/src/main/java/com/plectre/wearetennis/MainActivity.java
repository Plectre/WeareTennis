package com.plectre.wearetennis;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends WearableActivity {

    private Button btn_nous;
    private Button btn_eux;

    protected ImageView nous_jeux_1;
    protected ImageView nous_jeux_2;
    protected ImageView nous_jeux_3;
    protected ImageView nous_jeux_4;
    protected ImageView nous_jeux_5;
    protected ImageView nous_jeux_6;
    private DisplayManager dm;
    private ScoreManager sm;
    private Player nous;
    private Player eux;
    private ArrayList<ImageView> nousJeux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nous = findViewById(R.id.btn_nous);
        btn_eux = findViewById(R.id.btn_eux);
        nous_jeux_1 = findViewById(R.id._nous_jeu_1);
        nous_jeux_2 = findViewById(R.id._nous_jeu_2);
        nous_jeux_3 = findViewById(R.id._nous_jeu_3);
        nous_jeux_4 = findViewById(R.id._nous_jeu_4);
        nous_jeux_5 = findViewById(R.id._nous_jeu_5);
        nous_jeux_6 = findViewById(R.id._nous_jeu_6);
        // Enables Always-on
        //setAmbientEnabled();
        nousJeux = new ArrayList<>();
        nousJeux.add(nous_jeux_1);
        nousJeux.add(nous_jeux_2);
        nousJeux.add(nous_jeux_3);
        nousJeux.add(nous_jeux_4);
        nousJeux.add(nous_jeux_5);
        nousJeux.add(nous_jeux_6);


        //for (ImageView jeux: allJeux){jeux.setImageResource(R.drawable.bulle_pleine);}
        nous = new Player();
        eux = new Player();
        dm = new DisplayManager();
        sm = new ScoreManager();

        btn_nous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajout du point au joueur 1
                nous.addPoint();
                majScores();

         }
        });

       btn_eux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajout de point au joueur 2
                eux.addPoint();
                majScores();
            }
        });

    }

    // Mise à jour des scores sur les views
    private void majScores() {

        int pointNous = nous.getPoint();
        int pointEux = eux.getPoint();
        int gameEux = eux.getGame();

        String isGame = sm.isGame(pointNous, pointEux);// Test s'il y'à jeu
        if (isGame == "nous") {
            nous.addGame();
            int gameNous = nous.getGame();
            nousJeux.get(gameNous - 1).setImageResource(R.drawable.bulle_pleine);// Gestion des bulles
            nous.setPoint(0);
        }

        String strPtNous = dm.getScore(pointNous);
        String strPtEux = dm.getScore(pointEux);
        display(strPtNous, strPtEux);

    }

    private void display(String pt1, String pt2) {
        btn_nous.setText(pt1);
        btn_eux.setText(pt2);
    }
}
