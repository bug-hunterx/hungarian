/**
 * Created by adam_csordas on 1/16/2016.
 */
public class C9Runnable{
    static String f(String y){
        boolean m=false;
        int t=0,c=0,l=3;
        String e="piranha|koopa|goomba",r="???",end="Bowser|Princess";
        for(String s : y.split(" ")){
            if(s.isEmpty())continue;
            if(s.matches(end)){
                r="WIN";
                break;
            }
            if(s.matches("1Up"))l++;
            if(s.matches("Mushroom"))m=true;
            if(s.matches("\\d*")){
                c+=Integer.valueOf(s);
                l+=c / 100;
                c=c % 100;
            }
            if(s.matches(e)){
                if(!m && t <= 0)l--;
                if(m && t == 0)m=false;
                if(l == 0){
                    r="GAME OVER";
                    break;
                }
            }
            if(t>0)t--;
            if(s.matches("Star"))t=2;
        }
        System.out.print(r);
        return r;
    }
}
