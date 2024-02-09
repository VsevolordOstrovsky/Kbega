package com.example.kbega;

public class Proff {
    public String nameFlag;
    public int flag = 0;
    //{зарплата, налоги,выплата по ипотеке, выплата по кредиту на образование, выплата по кредиту на машину,выплата по кредитным карточкам, прочие расходы, Ипотека на дом, кредит на образование, кредиты на машину, задолжность по кр карточкам, расходы на детей, сбережения}
    private static int[] manager = {4600, 900,700,100,100,200,1000,75000,12000,6000,4000,300, 400};
    private static int[] mecanic = {2000, 400,300,0,100,100,400,31000,0,3000,3000, 100,700};
    private static int[] police = {3000,600,400,0,100,100,700,46000,0,5000,3000, 200,500};
    private static int[] cliner = {1600,200,0,100,100,300,20000,0,4000,3000,100, 600};
    private static int[] ingener = {4900,1000,700,100,200,200,1000,75000,12000,7000,5000,200, 400};
    private static int[] teacher = {3300,500,500,100,100,200,700,50000,12000,5000,4000,200, 400};
    private static int[] secretar = {2500,500,400,0,100,100,600,38000,0,4000,3000, 100,700};
    private static int[] yrist = {7500,1800,1100,300,200,200,1500,115000,78000,1100,7000, 400,2000};
    private static int[] doctor = {13200,3200,1900,700,300,200,2000,202000,150000,19000,10000, 700, 3500};
    private static int[] medsestra = {3100,600,400,100,100,200,600,47000,6000,5000,4000, 200, 500};
    private static int[] pilot = {9500,2000,1000,0,300,700,2000,90000,0,15000,22000,400, 2500};
    private static int[] driver = {2500,500,400,0,100,100,600,38000,0,4000,3000, 200,800};


    public int[] getName(String name){
        nameFlag = name;
        switch (name){
            case "manager":
                return manager;
            case "pilot":
                return pilot;
            default:
                return medsestra;
        }

    }

}
