import org.junit.Assert;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Exec9 {
    public static void main(String[] args) {
        Assert.assertEquals(fTest("piranha Princess piranha"), "WIN");
        Assert.assertEquals(fTest("1Up koopa goomba piranha Bowser"), "WIN");
        Assert.assertEquals(fTest("Star Mushroom  piranha goomba piranha goomba Princess"), "WIN");
        Assert.assertEquals(fTest(" piranha piranha piranha piranha"), "GAME OVER");
        Assert.assertEquals(fTest("piranha piranha Star goomba goomba Princess"), "WIN");
        Assert.assertEquals(fTest("10 40 koopa goomba 20 30 piranha piranha"), "GAME OVER");
    }

    static String fTest(String s){
        String[] map = s.trim().split("\\s+");
        Set e = new HashSet<>(Arrays.asList("piranha","goomba","koopa"));
        int coins = 0;
        boolean superM = false;
        int lives = 3;
        int star = 0;
        for (String act : map) {
            if (star>0) star--;
            if ("Bowser".equals(act) || "Princess".equals(act)) return "WIN";
            else if (e.contains(act) && star == 0) {
                if (superM) superM = false;
                else lives--;
                if (lives==0) return "GAME OVER";
            } else if ("Mushroom".equals(act)) {
                superM = true;
            } else if ("Star".equals(act)) {
                star = 3;
            } else if ("1Up".equals(act)) {
                lives++;
            }
            else try {
                coins+=Integer.parseInt(act);
                if (coins>=100){lives+=coins/100;coins=coins%100;}
            } catch(NumberFormatException n) {}
        }
        return "???";
    }

    static void f(String s){
        String[] map=s.trim().split("\\s+");
        Set e=new HashSet<>(Arrays.asList("piranha","goomba","koopa"));
        int c=0,l=3,r=0;boolean superM=false;
        for (String act : map){if(r>0)r--;if("Bowser".equals(act)||"Princess".equals(act))System.out.print("WIN");
            else if(e.contains(act)&&r==0){if(superM)superM=false;else l--;if(l==0)System.out.print("GAME OVER");
            }else if("Mushroom".equals(act)){superM=true;}else if("Star".equals(act)){r=3;}else if("1Up".equals(act)){l++;}
            else try{c+=Integer.parseInt(act);if(c>=100){l+=c/100;c=c%100;}}catch(NumberFormatException n){}
        }
        System.out.print("???");
    }
}
