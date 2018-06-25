package com.epam.notareligion;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH8 {
    public static String f(String text, int columnNumber, int widthOfColumn) {
        //make sure, that we have enough character to fill all colum
        int modus = text.length() % widthOfColumn;
        if (modus != 0) {
            for (int i = 0; i < widthOfColumn - modus; i++) {
                text += " ";
            }
        }
        String output="";
        // make sure, that we have enough character to fill all row
        modus = (text.length() / widthOfColumn ) % columnNumber;
        if (modus != 0) {
            for (int i = 0; i < widthOfColumn * (columnNumber - modus); i++) {
                text += " ";
            }
        }
        //calculate the row number
        int rowNumber = (text.length() / widthOfColumn )/ columnNumber;
        for (int row = 0; row < rowNumber; row++) {
            for (int j = 0; j < columnNumber; j++) {
                for (int i = row * widthOfColumn; i < (row * widthOfColumn) + widthOfColumn; i++) {
                    //play with the indexis (médzsik) in order to print text up to down in columns
                    output += text.charAt((j * rowNumber * widthOfColumn) + i);
                }
                output += j + 1 < columnNumber ? "|" : "";
            }
            output+=row+1<rowNumber?"\n":"";
        }
        return output;
    }

    public static void f2(String t, int c, int w) {
        //make sure, that we have enough character to fill all colum
        int m = t.length() % w;
        if (m != 0) {
            for (int i = 0; i < w - m; i++) {
                t += " ";
            }
        }
        // make sure, that we have enough character to fill all row
        m = (t.length() / w ) % c;
        if (m != 0) {
            for (int i = 0; i < w * (c - m); i++) {
                t += " ";
            }
        }
        //calculate the row number
        int r = (t.length() / w )/ c;
        for (int k = 0; k < r; k++) {
            for (int j = 0; j < c; j++) {
                for (int i = k * w; i < (k * w) + w; i++) {
                    //play with the indexis (médzsik) in order to print text up to down in columns
                    System.out.print(t.charAt((j * r * w) + i));
                }
                System.out.print(j + 1 < c ? "|" : "");
            }
            System.out.print(k+1<r?"\n":"");
        }
    }
}
