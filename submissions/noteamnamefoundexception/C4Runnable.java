package hu.epam.hackaton.noteamfoundexception.theApplication;

import java.util.*;

public class C4Runnable {
    
    static void f(String s) {
        s = s+"::::";
        char r;
        if ((r = r(s(s, 6))) != '?' || (r = r(s(s, 8))) != '?' || (r = r(s)) != ' ') {
            System.out.print(r);
        }
    }
    
    static char r(String s) {
        char[] c = s.toCharArray();
        char[] o = {c[0],c[2],c[4],c[6],c[8]};
        char[] x = {c[1],c[3],c[5],c[7]};
        return v(o(o))?'O':v(o(x))?'X':'?';
    }
    
    static String s(String s, int e) {
        return s.substring(0, e) + "::::";
    }
    
    static boolean v(String s) {
        String r = "(123.*)|(1.*4.*7.*)|(1.*5.*9.*)|(.?2.*5.*8.*)|(.*456.*)|(.?3.?5.?7.*)|(.*3.*6.*9.*)|(.*789.*)";
        return s.matches(r);
    }
    
    static String o(char[] c) {
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String args[]) {
        f("");
        f("5237649");
        f("52376498");
        f("523764918");
        
        f("352476");
        f("4268379");
        f("631854792");
        f("523764918");
        
        f("15243");
        f("15342");
        f("25143");
        f("25341");
        f("35142");
        f("35241");
        
        f("15243");
        f("15342");
        f("25143");
        f("25341");
        f("35142");
    }
}
