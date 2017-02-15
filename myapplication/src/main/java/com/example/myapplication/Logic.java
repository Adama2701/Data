package com.example.myapplication;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;


public class Logic {

    private String colors = "rby";
//creating an arraylist which holds the amount of randomized colors and expands it by 1 every time answered correctly

    public ArrayList colorSequence(int len){
        ArrayList<String> tempArray = new ArrayList<>();
        Random randomGenerator = new Random();
        int minlen = 1;
        for (int i = 0; i<len;i++){
            String tempString = "";
            for (int j = 0; j<minlen;j++){
                String randomColor = String.valueOf(colors.charAt(randomGenerator.nextInt(colors.length())));
                tempString = tempString + randomColor;
            }
        tempArray.add(tempString);
        minlen++;
        }
        return tempArray;
    }
}
