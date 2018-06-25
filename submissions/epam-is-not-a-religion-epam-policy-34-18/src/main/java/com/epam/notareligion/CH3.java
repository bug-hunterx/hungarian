package com.epam.notareligion;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

/**
 * First run without any optimalization score: 1678
 * Second run with sentence deduplicate score: 1564
 */
public class CH3 {

    public static void f3() {
        String[] a = new String[]{"Ghostbusters","\n","strange","If there's something strange","In you neighborhood","weird","Who you gonna call","If there's something weird","And it don't look good","I ain't afraid of no ghost","seeing things","If you're seeing things","Running through your head","you call","Who can you call","An invisible man","all alone","Sleeping in your bed","If you're all alone","Pick up the phone","And call","I here it likes the girls","Yeah yeah yeah yeah","Who ya gonna call","If you've had a dose of a","Freaky ghost baby","You better call","Lemme tell ya something","Bustin' makes me feel good","Don't get caught alone no no","When it comes through your door","Unless you just want some more","I think you better call","I can't hear you","ya call","Louder","Who can ya call","If you're","Who can","If there's something"};System.out.print(a[0]+a[1]+a[2]+a[39]+a[1]+a[3]+a[1]+a[4]+a[1]+a[0]+a[1]+a[5]+a[39]+a[1]+a[6]+a[1]+a[4]+a[1]+a[0]+a[1]+a[1]+a[7]+a[1]+a[7]+a[1]+a[1]+a[8]+a[33]+a[1]+a[9]+a[1]+a[10]+a[1]+a[0]+a[1]+a[11]+a[36]+a[1]+a[12]+a[1]+a[4]+a[1]+a[0]+a[1]+a[1]+a[7]+a[1]+a[7]+a[1]+a[1]+a[4]+a[1]+a[0]+a[1]+a[13]+a[33]+a[1]+a[14]+a[1]+a[15]+a[1]+a[0]+a[1]+a[1]+a[7]+a[1]+a[16]+a[1]+a[7]+a[1]+a[17]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[19]+a[1]+a[20]+a[1]+a[21]+a[1]+a[0]+a[1]+a[1]+a[22]+a[1]+a[23]+a[1]+a[1]+a[7]+a[1]+a[7]+a[1]+a[1]+a[24]+a[1]+a[1]+a[0]+a[1]+a[1]+a[25]+a[1]+a[26]+a[1]+a[27]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[27]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[28]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[29]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[30]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]);

        }

    public static void f2() {
        String[] a = new String[]{"Ghostbusters","\n","If there's something strange","In you neighborhood","Who you gonna call","If there's something weird","And it don't look good","I ain't afraid of no ghost","If you're seeing things","Running through your head","Who can you call","An invisible man","Sleeping in your bed","If you're all alone","Pick up the phone","And call","I here it likes the girls","Yeah yeah yeah yeah","Who ya gonna call","If you've had a dose of a","Freaky ghost baby","You better call","Lemme tell ya something","Bustin' makes me feel good","Don't get caught alone no no","When it comes through your door","Unless you just want some more","I think you better call","I can't hear you","Louder","Who can ya call"};System.out.print(a[0]+a[1]+a[2]+a[1]+a[3]+a[1]+a[4]+a[1]+a[0]+a[1]+a[5]+a[1]+a[6]+a[1]+a[4]+a[1]+a[0]+a[1]+a[1]+a[7]+a[1]+a[7]+a[1]+a[1]+a[8]+a[1]+a[9]+a[1]+a[10]+a[1]+a[0]+a[1]+a[11]+a[1]+a[12]+a[1]+a[4]+a[1]+a[0]+a[1]+a[1]+a[7]+a[1]+a[7]+a[1]+a[1]+a[4]+a[1]+a[0]+a[1]+a[13]+a[1]+a[14]+a[1]+a[15]+a[1]+a[0]+a[1]+a[1]+a[7]+a[1]+a[16]+a[1]+a[7]+a[1]+a[17]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[19]+a[1]+a[20]+a[1]+a[21]+a[1]+a[0]+a[1]+a[1]+a[22]+a[1]+a[23]+a[1]+a[1]+a[7]+a[1]+a[7]+a[1]+a[1]+a[24]+a[1]+a[1]+a[0]+a[1]+a[1]+a[25]+a[1]+a[26]+a[1]+a[27]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[27]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[28]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[29]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]+a[1]+a[1]+a[30]+a[1]+a[0]+a[1]+a[1]+a[18]+a[1]+a[0]);
        }

    public static void f() {
        System.out.println("Ghostbusters\n" +
                "If there's something strange\n" +
                "In you neighborhood\n" +
                "Who you gonna call\n" +
                "Ghostbusters\n" +
                "If there's something weird\n" +
                "And it don't look good\n" +
                "Who you gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "I ain't afraid of no ghost\n" +
                "I ain't afraid of no ghost\n" +
                "\n" +
                "If you're seeing things\n" +
                "Running through your head\n" +
                "Who can you call\n" +
                "Ghostbusters\n" +
                "An invisible man\n" +
                "Sleeping in your bed\n" +
                "Who you gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "I ain't afraid of no ghost\n" +
                "I ain't afraid of no ghost\n" +
                "\n" +
                "Who you gonna call\n" +
                "Ghostbusters\n" +
                "If you're all alone\n" +
                "Pick up the phone\n" +
                "And call\n" +
                "Ghostbusters\n" +
                "\n" +
                "I ain't afraid of no ghost\n" +
                "I here it likes the girls\n" +
                "I ain't afraid of no ghost\n" +
                "Yeah yeah yeah yeah\n" +
                "\n" +
                "Who ya gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "If you've had a dose of a\n" +
                "Freaky ghost baby\n" +
                "You better call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Lemme tell ya something\n" +
                "Bustin' makes me feel good\n" +
                "\n" +
                "I ain't afraid of no ghost\n" +
                "I ain't afraid of no ghost\n" +
                "\n" +
                "Don't get caught alone no no\n" +
                "\n" +
                "Ghostbusters\n" +
                "\n" +
                "When it comes through your door\n" +
                "Unless you just want some more\n" +
                "I think you better call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Who ya gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Who ya gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "I think you better call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Who ya gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "I can't hear you\n" +
                "Who ya gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Louder\n" +
                "Ghostbusters\n" +
                "\n" +
                "Who ya gonna call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Who can ya call\n" +
                "Ghostbusters\n" +
                "\n" +
                "Who ya gonna call\n" +
                "Ghostbusters");
    }

    public static void main( String[] args )
    {
        f3();
    }
}
