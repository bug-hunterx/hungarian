
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Exec4 {

    //    1. 352476 => X
    //    2. 4268379 => O
    //    3. 631854792 => ?
    //    4. 523764918 => O
    public static void main(String[] args) {
        f("5237649"); // O
        f("52376498"); // O
        f("523764918"); // O
        f("352476");
        f("4268379");
        f("631854792");
        f("523764918");
    }

    static void f(String s){
        int[][]i={{0,0,0},{0,0,0},{0,0,0}};
        char[]chars=s.toCharArray();
        int[]ints=new int[chars.length];
        int x,y,sumA=0,sumB=0;
        String res="?";
        for(int a=0;a<chars.length;a++){
            ints[a]=Character.getNumericValue(chars[a]);
        }

        int p=1;
        for(int anInt:ints){
            x=anInt%3==0?2:(anInt%3)-1;
            y=((anInt-1)/3);
            i[x][y]=p;

            int z=i[0][0]+i[0][1]+i[0][2];
            int b=i[1][0]+i[1][1]+i[1][2];
            int c=i[2][0]+i[2][1]+i[2][2];

            int d=i[0][0]+i[1][0]+i[2][0];
            int e=i[0][1]+i[1][1]+i[2][1];
            int f=i[0][2]+i[1][2]+i[2][2];

            int g=i[0][0]+i[1][1]+i[2][2];
            int h=i[0][2]+i[1][1]+i[2][0];

            if(z==3||b==3||c==3||d==3||e==3||f==3||g==3||h==3){
                sumA++;
            }
            if(z==12||b==12||c==12||d==12||e==12||f==12||g==12||h==12){
                sumB++;
            }
            if(sumA>sumB){
                res="O";
                break;
            }
            if(sumA<sumB){
                res="X";
                break;
            }
            p=p==1?4:1;
        }
        System.out.println(res);
    }
}
