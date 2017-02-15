package com.example.myapplication;

/**
 * Created by adama on 15-02-2017.
 */

public class Test {

    private int id;
    private int length;
    private boolean guess;
    private String name;



    Test(int length, boolean guess, String name){
        this.length = length;
        this.guess = guess;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public int getId(){
        return id;
    }

    public boolean getGuess(){
        return guess;
    }

    public String getName(){
        return name;
    }
}
