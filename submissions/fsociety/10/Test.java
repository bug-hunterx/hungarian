
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class codegolf_0 {

    public static void main(String[] args) {

        int i = 12;
                    String s = "apple";
                    double l = 3.14;
                    String filex = "/challenge_input/c0/input1.txt";
                    char c = 'a';
                    int count = 3;
                    
        f("    # \n  . \\  \n$ | | $");
    }

   static void f(int a,String b){int c=b.indexOf("\n")+1;int d=-1;int e=0;int f=0;int[] g=new int[b.length()];d=b.indexOf("X",d+1);int z=0;while(d>=0){if(d<(b.length()-c)){d=b.indexOf("X", d+1);continue;}int h=d-c;int j=i(b,h,c,false,0);if(j==-2){e++;}else if(j>=0){g[z++]=j;f++;}d=b.indexOf("X",d+1);}int k=e+f;if(k==0){System.out.println(":(");}else if(a>k){System.out.println(a-k);}else if(a<e){System.out.println(a-e);}else{for(int i=0;i<a-e;i++){StringBuilder l=new StringBuilder(b);l.setCharAt(g[i],'$');b=l.toString();}System.out.println(b);}}public static int i(String m,int o,int p,boolean q,int r){char t=m.charAt(o);if(t=='|'){return i(m,o-p,p,true,r);}else if(t=='\\'&&r<=0){return i(m,o-p,p,true,++r);}else if(t=='/'&&r>=0){return i(m,o-p,p,true,--r);}else if(t=='.'&&(q&&r==0)){return o;}else if(t=='$'&&q&&r==0){return -2;}else{return -1;}}
}

