package hu.epam.hackaton.noteamfoundexception.theApplication;

import java.util.*;

public class C3Runnable {

    static Map<Character, String> m = new HashMap<Character, String>();
    
    static void f() {
        p('a', "I ain't afraid of no ghost\n");
        p(' ', "\n");
        p('b', "Ghostbusters\n");
        p('c', "If there's something ");
        p('d', "strange\n");
        p('e', "In ");
        p('f', "you ");
        p('F', "You ");
        p('g', "neighborhood");
        p('W', "Who ");
        p('h', "gonna call\n");
        p('i', "weird");
        p('j', "And it don't look good");
        p('k', "If you're seeing things\nRunning through your head");
        p('m', "can ");
        p('n', "An invisible man\nSleeping in your bed");
        p('o', "If you're all alone\nPick up the phone");
        p('p', "And call\n");
        p('q', "I here it likes the girls");
        p('r', "Yeah ");
        p('s', "yeah yeah yeah\n");
        p('t', "ya ");
        p('u', "If you've had a dose of a\nFreaky ghost baby");
        p('v', "Lemme tell ya something\nBustin' makes me feel good");
        p('w', "Don't get caught alone no no");
        p('x', "When it comes through your door\nUnless you just want some more");
        p('y', "better ");
        p('z', "I think ");
        p('0', "I can't hear you");
        p('1', "Louder");
        p('C', "call\n");
        
        char[] s = "bcdefg Wfhbci j Wfhb aa k WmfCbn Wfhb aa Wfhbo pb aq ars Wthb u FyCb v  aa w  b x zfyCb Wthb Wthb zfyCb Wthb 0 Wthb 1 b Wthb WmtCb Wthb ".toCharArray();
        
        for (char c : s) System.out.print(m.get(c));
    }
    
    static void p(char c, String s) {
        m.put(c, s);
    }
    
    public static void main(String[] args) {
        f();
    }
}
