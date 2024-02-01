package com.example.kbega;

import com.example.kbega.Dox.Doxod;

import java.util.ArrayList;

public class Data {


    private static String nameSave;

    public static ArrayList<String> dataTimeNedv = new ArrayList<>();

    public void setName(String name){
        nameSave = name;
    }
    public String getName(){
        return nameSave;
    }

    public void addText(String text){
        dataTimeNedv.add(text);
    }


}
