package com.epam.notareligion;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH3_CreateSysoDeDuplicateWords {
    public static final String text = "Ghostbusters\n" +
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
            "Ghostbusters";

    public static void main(String args[]) {
        String newText = "";
        StringTokenizer tokenizer = new StringTokenizer(text, "\n", true);
        int index = 0;
        Map<String, Integer> words = new LinkedHashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String actualSentence = tokenizer.nextToken();
            StringTokenizer tokenizerWord = new StringTokenizer(actualSentence, " ", true);
            while (tokenizerWord.hasMoreTokens()) {
                String actualWord = tokenizerWord.nextToken();
                Integer indexOfWord = words.get(actualWord);
                if (indexOfWord == null) {
                    words.put(actualWord, index);
                    indexOfWord = index;
                    index++;
                }
                if (newText.length() == 0) {
                    newText += "a[" + indexOfWord + "]";
                } else {
                    newText += "+a[" + indexOfWord + "]";
                }
            }
        }
        System.out.print("String[] a = new String[]{");
        boolean first = true;
        for(Map.Entry<String, Integer> entry : words.entrySet()) {
            if (first) {
                System.out.print("\"" + entry.getKey() + "\"");
                first = false;
            } else {
                System.out.print(",\"" + entry.getKey() + "\"");
            }
        }
        System.out.print("};");
        System.out.print("System.out.print(" + newText + ");");
    }
}
