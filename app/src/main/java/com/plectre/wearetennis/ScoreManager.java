package com.plectre.wearetennis;

public class ScoreManager {
    private Player nous = new Player();
    private Player eux = new Player();


    public String isGame(int p1, int p2) {

        if (p1 == 6) {
            return "nous";
        } else
        return "eux";
    }
}
