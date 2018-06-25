package com.epam.notareligion;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH4 {

    public static String f(String g) {
        /*String[] w = new String[]{".*[147].*[147].*[147].*", ".*[258].*[258].*[258].*", ".*[369].*[369].*[369].*",
                ".*[123].*[123].*[123].*", ".*[456].*[456].*[456].*", ".*[789].*[789].*[789].*", ".*[159].*[159].*[159].*",
                ".*[357].*[357].*[357].*"};*/
        //String w = ".*[147].*[147].*[147].*|.*[258].*[258].*[258].*|.*[369].*[369].*[369].*|.*[123].*[123].*[123].*|.*[456].*[456].*[456].*|.*[789].*[789].*[789].*|.*[159].*[159].*[159].*|.*[357].*[357].*[357].*";


        //String w = ".*[147].*[147].*[147].*|.*[258].*[258].*[258].*|.*[369].*[369].*[369].*|.*[123].*[123].*[123].*|.*[456].*[456].*[456].*|.*[789].*[789].*[789].*|.*[159].*[159].*[159].*|.*[357].*[357].*[357].*";
        String w = "";
        int[] l = {147, 258, 369, 123, 456, 789, 159, 357};
        for (int i = 0; i< l.length; i++) {
            w += ".*[" + l[i] + "].*[" + l[i] + "].*[" + l[i] + "].*";
            w += l.length -1 > i ? "|" : "";
        }



        String o="", x="";
        for (int i = 0; i < g.length(); i++) {
            if (i % 2 == 0) {
                o += g.charAt(i);
            } else {
                x += g.charAt(i);
            }
            if (o.matches(w)) {
                return "O";
            } else if (x.matches(w)) {
                return "X";
            }
            /*for (String winnerCase : w) {
                if (o.matches(winnerCase)) {
                    return "O";
                } else if (x.matches(winnerCase)) {
                    return "X";
                }
            }*/
        }
        return "?";
    }

    public static void minif(String g) {
        String wc = ".*[147].*[147].*[147].*|.*[258].*[258].*[258].*|.*[369].*[369].*[369].*|.*[123].*[123].*[123].*|.*[456].*[456].*[456].*|.*[789].*[789].*[789].*|.*[159].*[159].*[159].*|.*[357].*[357].*[357].*";
        String o="", x="";
        for (int i = 0; i < g.length(); i++) {
            if (i % 2 == 0) {
                o += g.charAt(i);
            } else {
                x += g.charAt(i);
            }
            if (o.matches(wc)) {
                System.out.print("O");return;
            } else if (x.matches(wc)) {
                System.out.print("X");return;
            }
        }
        System.out.print("?");
    }

    public static void main(String args[]) {

    }
}
