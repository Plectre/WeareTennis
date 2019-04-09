package com.plectre.wearetennis;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.plectre.wearetennis.R.drawable.bulle_pleine;
import static java.lang.String.valueOf;

public class MainActivity extends WearableActivity {

    static Button btn_nous;
    static Button btn_eux;
    //private Player nous = new Player();
    //private Player eux = new Player();
    private ScoreManager scoreManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nous = findViewById(R.id.btn_nous);
        btn_eux = findViewById(R.id.btn_eux);
        // Enables Always-on
        //setAmbientEnabled();
        scoreManager = new ScoreManager();

        btn_nous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreManager.addPoint("nous");
            }
        });

        btn_eux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreManager.addPoint("eux");
            }
        });
    }
 }
