package com.reply;

public class Desk {
    // if 0 _ if 1 M
    public int type;
    private int x,y;
    public double deskScore;
    public Desk(int x,int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public boolean nextTo(Desk desk){
        return ((x == desk.x+1 || x == desk.x-1 || x == desk.x)
                && (y == desk.y+1 || y == desk.y-1 || y == desk.y)
                && (y != desk.y && x != desk.x));
    }
    public void setDeskScore(double score){
        deskScore = score;
    }


}
