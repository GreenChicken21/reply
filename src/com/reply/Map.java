package com.reply;

import java.util.ArrayList;

public class Map {
    private int w,h;
    private ArrayList<Desk> desks = new ArrayList<>();
    private ArrayList<ArrayList<String>> mapa = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> deskMap = new ArrayList<>();

    private ArrayList<ArrayList<Double>> desksCoeficient = new ArrayList<>();

    public void setDesksCoeficient(){

        for(int i = 0;i<desks.size();i++){
            ArrayList<Double> row = new ArrayList<>();
            for(int j = 0; j<desks.size();j++){
                row.add(deskMap.get(i).get(j)*desks.get(i).deskScore * desks.get(j).deskScore);
            }
            desksCoeficient.add(row);
        }
        for(int i = 0;i<desks.size();i++){
            double sum = 0;
            for(int j = 0;j<desks.size();j++){
                sum+=desksCoeficient.get(i).get(j);
            }
            desks.get(i).setDeskScore(sum/4);
        }
        for(int k = 0; k<2;k++){
            for(int i = 0;i<desksCoeficient.size();i++){
                ArrayList<Double> row = new ArrayList<>();
                for(int j = 0; j<desksCoeficient.size();j++){
                    row.add(desksCoeficient.get(i).get(j)*desks.get(i).deskScore * desks.get(j).deskScore);
                }
                desksCoeficient.add(row);
            }
        }
    }

    public void deskMapGenerate(){
        for(int i = 0;i<desks.size();i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0;j<desks.size();j++){
                if(i!=j && desks.get(i).nextTo(desks.get(j)))
                    row.add(1);
                else row.add(0);
            }
            deskMap.add(row);
        }
    }

    public void setDeskScores(){
        for(int i = 0;i<desks.size();i++){
            double sum = 0;
            for(int j = 0;j<desks.size();j++){
                sum+=deskMap.get(i).get(j);
            }
            desks.get(i).setDeskScore(sum/4);
        }
    }
    public Map(int w, int h, ArrayList<ArrayList<String>> mapa) {
        this.w = w;
        this.h = h;
        this.mapa = mapa;
    }


    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public ArrayList<ArrayList<String>> getMapa() {
        return mapa;
    }

    public void setMapa(ArrayList<ArrayList<String>> mapa) {
        this.mapa = mapa;
    }

    public void fill(int x, int y, String s){
        mapa.get(x).set(y,s);
    }


}
