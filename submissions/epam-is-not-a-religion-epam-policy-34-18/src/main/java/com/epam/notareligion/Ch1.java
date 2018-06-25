package com.epam.notareligion;


import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

/**
 * ----------------
 ​*The task*​

 ```f(input: string)```

 Print the input with its characters sorted by their frequency (ascending).

 ​*Rules*​

 Input will only contain printable ASCII characters. Characters with the same frequency should be ordered by their ASCII values (ascending).


 ​*Example Test-Cases*​

 > Note: you submission will be tested using a lot more inputs

 1. `Hello, World!` => ` !HWderoolll`
 2. `Results, Relentlessly` => ` ,nuyRRtteeeellllssss`


 *
 */
public class Ch1
{
    public static void f(String i) {
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0 ; j< i.length(); j++) {
            Integer c = map.get(i.charAt(j));
            map.put(i.charAt(j), c == null ? 1 : c + 1);
        }
        map.entrySet().stream().sorted((o1, o2) -> {
            int c = o1.getValue().compareTo(o2.getValue());
            if (c == 0) {
                c = o1.getKey().compareTo(o2.getKey());
            }
            return c;
        }).forEach(characterIntegerEntry -> {
            for (int i1 = 0; i1 < characterIntegerEntry.getValue(); i1++)
                System.out.print(characterIntegerEntry.getKey());
        });
    }

    public static void main( String[] args )
    {
        String in = "Results, Relentlessly";
        f(in);

    }
}
