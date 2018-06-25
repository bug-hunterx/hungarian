import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Exec12 {

    public static void main(String[] args) {
        String scene = "hh>>  \n"+
                       "Hw>>  \n"+
                       "Wvv>  \n"+
                       "wvv>  ";
        //f(scene, 3, 3);

        String scene2 = ">v>v>v\n" +
                "^v^v^v\n" +
                "^v^v^v\n" +
                "^>^>^v\n" +
                "^<<<<<";
        //f(scene2, 2, 1);
        //f(scene2, 2, 5);
        //f(scene2, 3, 2);
        f(scene2, 6, 5);

        String scene3 = ">vhv>v\n" +
                "^v>v^v\n" +
                "^vHvwW\n" +
                "^>^>>v\n" +
                "^<<<<<";
        //f(scene3, 2, 3);

        String scene4 = "> <vv    <\n" +
                        " v ^ >v v \n" +
                        "  >v^^>vv^\n" +
                        "    ^>^ v ";
        //f(scene4, 6, 1);
    }

    static void f(String s, int w, int h){
        int r=0,c=0,pc=0,pr=0;
        String[] m=s.split("\n");char[][] map = new char[m.length][m[0].length()];
        int actLine = 0;
        boolean ho=true,ve=true;
        for (String a : m) {map[actLine]=a.toCharArray();actLine++;}
        List<Integer> rH = new ArrayList<>();
        List<Integer> cH = new ArrayList<>();
        while(true) {
            rH.add(r);cH.add(c);
            char[][] box = get(map, r, c, w, h);
            int dR=0,dC=0;
            Map<Character, Integer> e=evaulateBox(box);
            if(e.get('h')==null && e.get('H')!=null)ho=true;
            else if(e.get('h')!=null && e.get('H')==null)ho=false;
            else if(e.get('h')==e.get('H'))ho=ho;
            else if(e.get('h')>e.get('H'))ho=false;
            else ho=true;

            if(e.get('w')==null && e.get('W')!=null)ve=true;
            else if(e.get('w')!=null && e.get('W')==null)ve=false;
            else if(e.get('w')==e.get('W'))ve=ve;
            else if(e.get('w')>e.get('W'))ve=false;
            else ve=true;

            if (e.get('>')!=null)dC+=e.get('>');
            if (e.get('<')!=null)dC-=e.get('<');

            if (e.get('v')!=null)dR+=e.get('v');
            if (e.get('^')!=null)dR-=e.get('^');

            if (!ho && ve) {
                if(dR>0){r++;pr=1;pc=0;}else if(dR<0){r--;pr=-1;pc=0;}
            } else if(ho && !ve) {
                if(dC>0){c++;pc=1;pr=0;}
                else if(dC<0){c--;pc=-1;pr=0;}
            } else if(dC*dC > dR*dR) {
                if(dC>0){c++;pc=1;pr=0;}
                else if(dC< 0){c--;pc=-1;pr=0;}
            } else if(dC*dC < dR*dR) {
                if(dR>0){r++;pr=1;pc=0;}
                else if(dR<0){r--;pr=-1;pc=0;}
            } else if(dR!=0 && dR*dR==dC*dC){
                if(r==0 && c==0){c+=1;pc=1;pr=0;
                }else{if(pr!=0){if(dR>0){r++;}else if(dR<0){r--;}}else if(pc!=0){if(dC>0){c++;}else if(dC<0){c--;}}}
            }
            if (rH.get(rH.size()-1)==r && cH.get(cH.size()-1)==c){System.out.print("9");break;}
            boolean inf=false;
            for(int i=0;i<rH.size();i++){if(rH.get(i)==r && cH.get(i)==c){inf=true;}}
            if(inf){System.out.print("8");break;}
        }
    }

    static char[][] get(char[][] map,int row,int col,int width,int height) {
        char[][] out = new char[height][width];
        int actLine=0;
        for(int i=0;i<map.length;i++){if(i>=row && i<row+height){Arrays.fill(out[actLine], ' ');for(int j=0;j<map[i].length;j++) {if(j>=col && j<col+width){out[actLine][j-col]=map[i][j];}}actLine++;}}
        return out;
    }

    static Map<Character,Integer> evaulateBox(char[][] box) {
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<box.length;i++){for(int j=0;j<box[i].length;j++){if(m.get(box[i][j])==null)m.put(box[i][j],1);else m.put(box[i][j],m.get(box[i][j])+1);}}
        return m;
    }
}
