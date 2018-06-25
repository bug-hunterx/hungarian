package com.epam.notareligion;

import java.util.*;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH3_CreateSysoDeDuplicateSentencesAndAfterOptimizeSentenceDifferences {
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

    public static boolean similarSentence(String sentence1, String sentence2) {
        StringTokenizer wordsForFirstSentence = new StringTokenizer(sentence1, " ");
        StringTokenizer wordsForSecondSentence = new StringTokenizer(sentence2, " ");
        int similarWords = 0;
        while(wordsForFirstSentence.hasMoreTokens() && wordsForSecondSentence.hasMoreTokens() && similarWords < 2) {
            if (wordsForFirstSentence.nextToken().equals(wordsForSecondSentence.nextToken())) {
                similarWords++;
            } else {
                break;
            }
        }
        return similarWords == 2;
    }

    public static String[] similarSentenceExtract(String sentence1, String sentence2) {
        StringTokenizer wordsForFirstSentence = new StringTokenizer(sentence1, " ");
        StringTokenizer wordsForSecondSentence = new StringTokenizer(sentence2, " ");
        String commonSentencePart = "";
        String notCommonFirst = "";
        String notCommonLast = "";
        boolean different = false;
        boolean commonSentencePartFirst = true;
        boolean notCommonFirstFirst = true;
        boolean notCommonLastFirst = true;
        while(wordsForFirstSentence.hasMoreTokens() && wordsForSecondSentence.hasMoreTokens()) {
            String firstWord = wordsForFirstSentence.nextToken();
            String secondWord = wordsForSecondSentence.nextToken();
            if (!different && firstWord.equals(secondWord)) {
                if (commonSentencePartFirst) {
                    commonSentencePartFirst = false;
                } else {
                    commonSentencePart += " ";
                }
                commonSentencePart += firstWord;
            } else {
                different = true;
                if (notCommonFirstFirst) {
                    notCommonFirstFirst = false;
                } else {
                    notCommonFirst += " ";
                }
                notCommonFirst += firstWord;
                if (notCommonLastFirst) {
                    notCommonLastFirst = false;
                } else {
                    notCommonLast += " ";
                }
                notCommonLast+= secondWord;
            }
        }
        return new String[]{commonSentencePart, notCommonFirst, notCommonLast};
    }

    public static void main(String args[]) {
        List<Integer> newText = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text, "\n", true);
        List<String> sentences = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String actualSentence = tokenizer.nextToken();
            Integer indexOfSentence = sentences.indexOf(actualSentence);
            if (indexOfSentence == -1) {
                sentences.add(actualSentence);
                indexOfSentence = sentences.size() - 1;
            }
            newText.add(indexOfSentence);
        }
        Map<String, String> similarSentences = new HashMap<>();
        for(String entry : sentences) {
            for(String entry2 : sentences) {
                if (!(entry.equals(entry2)) &&
                        !similarSentences.containsKey(entry) && !similarSentences.containsValue(entry)  &&
                        !similarSentences.containsKey(entry2) && !similarSentences.containsValue(entry2)  &&
                        similarSentence(entry, entry2)) {
                    similarSentences.put(entry, entry2);
                }
            }
        }
        for(Map.Entry<String, String> entry : similarSentences.entrySet()) {
            String[] extracted = similarSentenceExtract(entry.getKey(), entry.getValue());
            ListIterator<Integer> iterator = newText.listIterator();
            int index1 = sentences.indexOf(entry.getKey());
            int index2 = sentences.indexOf(entry.getValue());
            sentences.add(extracted[0]);
            sentences.add(index1, extracted[1]);
            sentences.add(index2, extracted[2]);
            while (iterator.hasNext()) {
                Integer actualIndex = iterator.next();
                if (actualIndex.equals(index1) || actualIndex.equals(index2)) {
                    iterator.add(sentences.size() - 1);
                }
            }
        }
        System.out.print("String[] a = new String[]{");
        boolean first = true;
        for(String entry : sentences) {
            if (first) {
                System.out.print("\"" + entry + "\"");
                first = false;
            } else {
                System.out.print(",\"" + entry + "\"");
            }
        }
        System.out.print("};");
        System.out.print("System.out.print(");
        first = true;
        for (Integer actualIndex : newText) {
            if (first) {
                first = false;
                System.out.print("a[" + actualIndex + "]");
            } else {
                System.out.print("+a[" + actualIndex + "]");
            }
        }

        System.out.print(");");
    }
}
