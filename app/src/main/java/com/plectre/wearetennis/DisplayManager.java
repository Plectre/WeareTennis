package com.plectre.wearetennis;

public class DisplayManager {

    private String scores[] = {"0", "15", "30", "40", "EG", "AV", "Jeu","OO"};



    public String getScore(int pt) {
        return scores[pt];
    }
}
