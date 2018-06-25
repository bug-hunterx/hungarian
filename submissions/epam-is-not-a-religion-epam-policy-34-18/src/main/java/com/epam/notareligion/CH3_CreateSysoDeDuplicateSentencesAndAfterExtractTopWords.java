package com.epam.notareligion;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH3_CreateSysoDeDuplicateSentencesAndAfterExtractTopWords {

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
        StringTokenizer wordsForSecondSentence = new StringTokenizer(sentence1, " ");
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
        final int[] index = {0};
        Map<String, Integer> sentences = new LinkedHashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String actualSentence = tokenizer.nextToken();
            Integer indexOfSentence = sentences.get(actualSentence);
            if (indexOfSentence == null) {
                sentences.put(actualSentence, index[0]);
                indexOfSentence = index[0];
                index[0]++;
            }
            newText.add(indexOfSentence);
        }
        Map<String, Integer> countWords = new HashMap<>();
        for(Map.Entry<String, Integer> entry : sentences.entrySet()) {
            tokenizer = new StringTokenizer(entry.getKey(), " ");
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word));
                } else {
                    countWords.put(word, 1);
                }
            }
        }
        Map<String, String> sentencesNeedToSplit = new HashMap<>();
        countWords.entrySet().stream().filter(new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> stringIntegerEntry) {
                return stringIntegerEntry.getValue() < 4;
            }
        }).forEach(new Consumer<Map.Entry<String, Integer>>() {
            @Override
            public void accept(Map.Entry<String, Integer> wordWithCount) {
                for(Map.Entry<String, Integer> entry : sentences.entrySet()) {
                    if (!sentencesNeedToSplit.containsKey(entry.getKey()) && entry.getKey().contains(wordWithCount.getKey())) {
                        sentencesNeedToSplit.put(entry.getKey(), wordWithCount.getKey());
                    }
                }
            }
        });

        for(Map.Entry<String, String> entry : sentencesNeedToSplit.entrySet()) {
                String originalSentence = entry.getKey();
                String[] newSentences = originalSentence.split(entry.getValue());
                if (newSentences.length  == 2) {
                    ListIterator<Integer> iterator = newText.listIterator();
                    int indexOfOriginalSentence = sentences.get(entry.getKey());
                    int outerFirst = ++index[0];
                    sentences.put(newSentences[0], index[0]);
                    sentences.put(entry.getValue(), sentences.remove(originalSentence));
                    int outerLast = ++index[0];
                    sentences.put(newSentences[1], index[0]);
                    List<Integer> problematicIndexes = new LinkedList<>();
                    while (iterator.hasNext()) {
                        Integer actualIndex = iterator.next();
                        if (actualIndex.equals(indexOfOriginalSentence)) {
                            problematicIndexes.add(iterator.nextIndex() - 1);
                        }
                    }
                    for (Integer problematicIndex : problematicIndexes) {
                        newText.add(problematicIndex - 1, outerFirst);
                        newText.add(problematicIndex + 1, outerLast);
                    }
                }
        }

        System.out.print("String[] a = new String[]{");
        boolean first = true;
        for(Map.Entry<String, Integer> entry : sentences.entrySet()) {
            if (first) {
                System.out.print("\"" + entry.getKey() + "\"");
                first = false;
            } else {
                System.out.print(",\"" + entry.getKey() + "\"");
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
