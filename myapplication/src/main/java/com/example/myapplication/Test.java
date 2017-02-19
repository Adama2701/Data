package com.example.myapplication;


public class Test {

    private int id;
    private int score;
    private String name;



    Test( int score, String name){

        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
