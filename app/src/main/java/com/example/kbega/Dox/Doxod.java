package com.example.kbega.Dox;

import android.util.Log;
import android.widget.TextView;

import com.example.kbega.Data;
import com.example.kbega.Proff;
import com.example.kbega.VnutrKrug;

public class Doxod {
    static Data data = new Data();
    Proff proff = new Proff();

    // 0 - название, 1 - цена, 2 - ипотека, 3 - взнос, 4 - денежный потоk

    private static String[] znachF = {"0","0","0","0","0"};
    public static int idDox;
    private int[] num = proff.getName(data.getName());
    private int koff = data.dataTimeNedv.size();

    public int pass_Dox = plusPass(data.dataTimeNedv.size());



    public static int ob_Dox;

    public void update(){
        ob_Dox = num[0] + pass_Dox;
    }

    public void setZnachF(String[] znach){
        znachF = znach;
        pass_Dox+=Integer.parseInt(znachF[4]);

        Log.i("Seva", String.valueOf(num[0]));

    }
    public String[] getZnachF(){
        return znachF;
    }
    private int plusPass(int len){
        int summ = 0;
        for(int i = 4; i < len; i += 5){
            summ+=Integer.parseInt(data.dataTimeNedv.get(i));
        }
        return summ;
    }






}
