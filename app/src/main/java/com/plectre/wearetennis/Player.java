package com.plectre.wearetennis;

public class Player {

    private int point;
    private int game;
    private int set;
    public DisplayManager dm;
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
        point = pt;
    }
    /*
    public void addPoint(String player) {
        dm = new DisplayManager();
        point++;
        dm.updatepoint(player, point);
        //Log.i(player, String.valueOf(this.point));
    }*/
}
