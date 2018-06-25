package com.epam.hackathon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Challenge_1_full {

    public static void main(final String[] args) {
        f("Results, Relentlessly");
    }

    public static void f(final String s) {
        final char[] charArray = s.toCharArray();
        final Map<Character, String> map = new HashMap<>();
        for (final char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + c);
            } else {
                map.put(c, "" + c);
            }
        }
        map.entrySet()
                .stream()
                .sorted(((Comparator<Entry<Character, String>>) (e1, e2) -> e1.getValue().length() - e2.getValue().length())
                        .thenComparing((e1, e2) -> (int) e1.getKey() - (int) e2.getKey()))
                .forEach(entry -> System.out.print(entry.getValue()));
    }

}
