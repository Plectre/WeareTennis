package com.plectre.wearetennis;

import android.util.Log;
/* Manage le score, verifie s'il y'a un gagnant */
public class ScoreManager {

    private DisplayManager dm = new DisplayManager();
    private Player nous = new Player();
    private Player eux = new Player();


    public void addPoint(String player) {

        if (player == "nous") {
            int pt = nous.getPoint();
            pt++;
            nous.setPoint(pt);
            //Log.i(player, String.valueOf(nous.getPoint()));
            dm.updateDisplayPoint(player, pt);
            isWinner(player);
        }else{
            int pt = eux.getPoint();
            pt++;
            eux.setPoint(pt);
            //Log.i(player, String.valueOf(eux.getPoint()));
            dm.updateDisplayPoint(player, pt);
            isWinner(player);
        }
    }

    // Check if has winner
    public void isWinner(String player) {
            int p1 = nous.getPoint();
            int p2 = eux.getPoint();

            // Premmier tableau
            if (p1 <=4 || p2 <=4) {
                if (p1 > 3 && p2 <= 2) {
                    //Log.i("the winner is", "NOUS");
                    dm.updateDisplayPoint(player, 6);
                    Log.d("JEU", "nous");
                    razScore();
                }
                if (p2 > 3 && p1 <= 2) {
                    //Log.i("the winner is", "EUX");
                    dm.updateDisplayPoint(player, 6);
                    Log.d("JEU", "eux");
                    razScore();
                }
            }
            // Egalité
            if (p1 == 3 && p2 == 3) {
               egal();
            }
            // Avantage
            else if (p1 == 5 && p2 == 4){
                avantage("nous");
            }
            else if (p2 == 5 && p1 == 4){
                avantage("eux");
            }
            else if (p1 == p2) {
                egal();
            }
            // jeu
            else if (p1 >3 && p2 >3) {
                if (Math.abs(p1 - p2) > 1) {
                    jeu(p1, p2);
                }
            }
    }

    public void egal() {
        eux.setPoint(4);
        nous.setPoint(4);
        dm.updateDisplayPoint("nous", 4);
        dm.updateDisplayPoint("eux", 4);
    }
    private void avantage(String player) {
        if (player == "nous") {
            nous.setPoint(5);
            dm.updateDisplayPoint(player, 5);
        } else {
            eux.setPoint(5);
            dm.updateDisplayPoint(player, 5);
        }
    }

    public void jeu(int scoreP1, int scoreP2) {

        if (scoreP1 > scoreP2) {
            razScore();
            Log.d("JEU", "nous");
        }
        else if (scoreP2 > scoreP1){
            Log.d("JEU", "eux");
            razScore();
        }
    }

    public void razScore() {
        eux.setPoint(0);
        nous.setPoint(0);
        dm.updateDisplayPoint("nous", 0);
        dm.updateDisplayPoint("eux", 0);
    }
}