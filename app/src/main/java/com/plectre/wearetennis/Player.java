package com.plectre.wearetennis;

public class Player {

    private int point = 0;
    private int game = 0;
    private int set = 0;

    //-------- GETTERS ------------
    public int getGame() {
        return game;
    }
    public int getSet() {
        return set;
    }
    public int getPoint(){
        return point;
    }

    //--------- SETTERS -----------
    public void setPoint(int pt) {
        this.point = pt;
    }
    public void setGame(int game){
        this.game = game;
    }

    public void addPoint() {
        point++;
    }
    public void addGame() {game++;}
    public void addSet() {set++;}
}
