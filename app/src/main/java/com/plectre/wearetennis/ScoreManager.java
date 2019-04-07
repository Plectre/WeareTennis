package com.plectre.wearetennis;

import android.util.Log;
/* Manage le score, verrifie s'il y'a un gagnant */
public class ScoreManager {

    private DisplayManager dm = new DisplayManager();
    private Player nous = new Player();
    private Player eux = new Player();


    public void addPoint(String player) {

        if (player == "nous") {
            int pt = nous.getPoint();
            pt++;
            nous.setPoint(pt);
            Log.i(player, String.valueOf(nous.getPoint()));
            dm.updateDisplayPoint(player, pt);
        }else{
            int pt = eux.getPoint();
            pt++;
            eux.setPoint(pt);
            Log.i(player, String.valueOf(eux.getPoint()));
            dm.updateDisplayPoint(player, pt);
        }
    }

    // Check if has winner
    public boolean isWinner(int p1, int p2) {


        return true;
    }
}