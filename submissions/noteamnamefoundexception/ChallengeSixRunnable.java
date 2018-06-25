package hu.epam.hackaton.noteamfoundexception.theApplication;

import java.io.PrintStream;

public class ChallengeSixRunnable {
    public static void main(String[] args) {
        f(100);
        f(15220);
        f(1199);
        f(1999);
        f(6185);
        f(6288);
        f(2800);
        f(2500);
    }   
    static void f(int cost){
        int tip = 0;
        PrintStream s = System.out;
        if(cost < 2000){ 
            tip = (((cost + 99) / 100 ) * 100)-cost;
            cost += tip;
        }else if(cost < 5000){
            tip = (((cost + 499) / 500 ) * 500)-cost;
            cost += tip;
        }else{
            tip = (int) (cost*0.1);
            int o = cost; 
            cost = (int)(((float)(cost+tip)/500)+0.5)*500;
            tip = cost - o;
        }
    
        if(tip==0||tip>1500) 
            s.println("PAID BY CARD");
        else if(tip%100>0) 
            s.println("KEEP THE CHANGE YOU FILTY ANIMAL"); 
        else s.println("HERE IS "+cost);
    }
    
}
