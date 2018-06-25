package com.epam.notareligion;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Zoltan_Kornel_Torok on 1/16/2016.
 */
public class CH8Test {

    @Test
    public void testFirst() {
        assertEquals(CH8.f("Results, Relentlessly", 3, 4),"Resu|.Rel|essl\n" + "lts,|entl|y...");
    }

    @Test
    public void testTwo() {
        assertEquals(CH8.f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5), "This.|t.wit|unnee|.....\n" +
                "is.a.|h,.a,|ded,.|..spa\n" +
                "longe|.lot,|comma|ces..\n" +
                "r.tex|.of,.|..And|.....");
    }

    @Test
    public void testThree() {
        assertEquals(CH8.f("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 3, 1), "0|l|G\n" +
                "1|m|H\n" +
                "2|n|I\n" +
                "3|o|J\n" +
                "4|p|K\n" +
                "5|q|L\n" +
                "6|r|M\n" +
                "7|s|N\n" +
                "8|t|O\n" +
                "9|u|P\n" +
                "a|v|Q\n" +
                "b|w|R\n" +
                "c|x|S\n" +
                "d|y|T\n" +
                "e|z|U\n" +
                "f|A|V\n" +
                "g|B|W\n" +
                "h|C|X\n" +
                "i|D|Y\n" +
                "j|E|Z\n" +
                "k|F|.");
    }


}