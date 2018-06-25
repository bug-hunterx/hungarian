import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class c6 {

    public static void main(String[] args) {
        f(100); //` => `PAID BY CARD`
        f(15000); //` => `HERE IS 16500`
        f(1199); //` => `KEEP THE CHANGE YOU FILTY ANIMAL`
        f(1999); //` => `KEEP THE CHANGE YOU FILTY ANIMAL`
        f(6185); //` => `KEEP THE CHANGE YOU FILTY ANIMAL`
        f(6288); //` => `KEEP THE CHANGE YOU FILTY ANIMAL`
        f(2800); //` => `HERE IS 3000`
        f(2500); //` => `PAID BY CARD
        f(6138);
        f(6100);
        f(2700);
        f(2200);
    }

    static void _f(int cost) {
    	String x = "PAID BY CARD";
    	String y = "KEEP THE CHANGE YOU FILTY ANIMAL";
    	//System.out.println(cost);
    	int rounded = cost;

    	if (cost < 2000) {
    		while (rounded%100>0) rounded++;
    	} else if (rounded < 5000) {
    		while (rounded%500>0) rounded++;
    	} else {
    		rounded = (int)((float)cost*1.1f);
    		//System.out.println("ROUNDED: "+rounded);
    		rounded = Math.round(rounded / 500f) * 500;
    		
    		//while (rounded%500>0) rounded++;
    	}


		int tip=rounded-cost;
		//System.out.println("COST: "+cost);
		//System.out.println("ROUNDED: "+rounded);
		//System.out.println("TIP: "+tip);
		if (tip<0 || tip > 1500) {
			System.out.println(x);
		} else if (tip % 100 >0) {
			System.out.println(y);
		} else {
			System.out.println("HERE IS "+rounded);
		}
    }

static void f2(int c){String m;int r=c;if(r<2000){while(r%100>0)r++;}else if(r<5000){while(r%500>0)r++;}else{
r=Math.round((int)((float)c*1.1f)/500f)*500;
}
c=r-c;
if(c<1||c>1500){
m="PAID BY CARD";
}else if(c%100>0){
m="KEEP THE CHANGE YOU FILTY ANIMAL";
}else{
m="HERE IS "+r;
}
System.out.println(m);
}

static void f(int c){String m;int r=c;if(r<2000)while(r%100>0)r++;else if(r<5000)while(r%500>0)r++;else r=Math.round((int)((float)c*1.1f)/500f)*500;c=r-c;if(c<1||c>1500)m="PAID BY CARD";else if(c%100>0)m="KEEP THE CHANGE YOU FILTY ANIMAL";else m="HERE IS "+r;System.out.println(m);}

}