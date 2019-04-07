package com.plectre.wearetennis;

/* Gére l'affichage */
public class DisplayManager extends MainActivity {
    //--------- GETTERS -----------------
    public int getPoint() {
        return point;
    }
    // ---------- SETTERS ----------------
    public void setPoint(int point) {
        this.point = point;
    }

    private int point;
    private String[] tabScore = {"0", "15", "30", "40", "EG", "AV","Jeu"};
    //private Button btn_nous;

    public void updateDisplayPoint(String player, int pt) {
        if (player == "nous") {
            btn_nous.setText(tabScore[pt]);
        }else{
            btn_eux.setText(tabScore[pt]);
        }
    }

}
