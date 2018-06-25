package com.epam.notareligion;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

/*
----------------
See http://xkcd.com/1530/.


​*The task*​

```f(input: string)```

Print the characters to `STDOUT` that do not belong. (I.e. characters with the least frequency of a given keyboard row.)

They should be keyboard-ordered (and not input-ordered). Unshifted characters come first. Each character should be printed once only.


​*Rules*​

Our eight-handed friend has set his keyboard to International English and uses Windows >8<. Input will not have white-space, special characters, control keys, accented characters, etc.

If there is a tie between two keyboard rows:

:one: print the one with the least amount of unique characters
:two: print the topmost row


Example Test-Cases*​

1. `FJAFJKLDSKF7JKFDJ` => `7`
2. `ASDFDSASDFDSAzxcPOIUY` => `zxc`
> Chars with least frequency of a given row
3. `qwERfgHJ123456789` => `qwER`
> Topmost row wins; note the ordering
4. `FGhjKL:"';lkqwerzxcc` => `zxc`
> Least amount of unique chars; `zxc` vs. `qwer`
5. `ASDFASDFqwer432!` => `234!`
6. `EUIyouiepIEjhadSDJ(*Y9y9` => `9*(`
7. `1233AERSdfqw` => `123`
8. `ASDF11!*&+1` => `ASDF`
9. `}*3%&2098@$2k234#@$M` => `}`
10. `wqfdSREA3321` => `123`
11. `:X:D:):DDDDDDDxDDDD:(;);];]` => `]`


 */

public class Ch2 {
    public static String f2(String i) {
        String[] keyboard = new String[] {"`1234567890-=~!@#$%^&*()_+" , "qwertyuiopQWERTYUIOP{}|[]\\",
                "asdfghjklASDFGHJKL;':\"", "zxcvbnmZXCVBNM,./<>?"};
        String[] input = new String[]{"","","",""};
        boolean[][] uniqueInput = new boolean[][]{new boolean[keyboard[0].length()], new boolean[keyboard[1].length()], new boolean[keyboard[2].length()], new boolean[keyboard[3].length()]};
        int min = 0;
        for (int index = 0 ; index < i.length() ; index++ ) {
            for (int j = 0 ; j < keyboard.length ; j++ ) {
                if (keyboard[j].indexOf(i.charAt(index)) > -1) {
                    input[j] += i.charAt(index);
                    if (!uniqueInput[j][keyboard[j].indexOf(i.charAt(index))]) {
                        uniqueInput[j][keyboard[j].indexOf(i.charAt(index))] = true;
                    }
                    min = j;
                    break;
                }
            }
        }
        //calculate row unique character numbers
        int[] num = new int[4];
        for (int j = 0; j < uniqueInput.length; j++) {
            for (int k = 0; k < uniqueInput[j].length; k++) {
                if (uniqueInput[j][k]) {
                    num[j]++;
                }
            }
        }
        //search the row which have the least unique character
        for (int j = 0; j < input.length; j++) {
            if (num[min] > num[j] && num[j] != 0) {
                min = j;
            }
        }
        // if more than one more has the same unique charahter length, then return the top row
        for (int j = 0; j < uniqueInput.length; j++) {
            if (num[min] == num[j] && j < min) {
                min = j;
            }
        }
        String out = "";
        for (int j = 0; j < uniqueInput[min].length; j++) {
            if (uniqueInput[min][j]) {
                out += keyboard[min].charAt(j);
            }
        }
        return out;
    }

    public static String f(String i) {
        Map<Integer, String> map = new HashMap<>();
        List<String> rowList = new ArrayList<>();
        rowList.add("`1234567890-=~!@#$%^&*()_+");
        rowList.add("qwertyuiopQWERTYUIOP{}|[]\\");
        rowList.add("asdfghjklASDFGHJKL;':\"" );
        rowList.add("zxcvbnmZXCVBNM,./<>?");
        int[] lengths={0,0,0,0};

        for (int index = 0 ; index < i.length() ; index++ ) {
            String actualChar = String.valueOf(i.charAt(index));
            for(int ri = 0 ; ri < rowList.size() ; ri++) {
                if(rowList.get(ri).contains(actualChar)) {
                    if (map.get(ri) != null) {
                        if (!map.get(ri).contains(actualChar)) {
                            int charIndex = rowList.get(ri).indexOf(actualChar);
                            boolean successInsert = false;
                            for (int si = 0 ; si < map.get(ri).length() ; si++) {
                                String s = map.get(ri);
                                int mapCharIndex = rowList.get(ri).indexOf(String.valueOf(s.charAt(si)));
                                if (charIndex < mapCharIndex) {
                                    map.put(ri, s.substring(0, si) + actualChar + s.substring(si));
                                    successInsert = true;
                                    break;
                                }
                            }
                            if (!successInsert) map.put(ri, map.get(ri) + actualChar);
                        }
                    } else {
                        map.put(ri, actualChar);
                    }
                    lengths[ri] = ++lengths[ri];
                }
            }
        }

        return (
        map.entrySet().stream().sorted((o1, o2) -> {
            int c = 0;
            if(lengths[o1.getKey()] != lengths[o2.getKey()])
                c = lengths[o1.getKey()] < lengths[o2.getKey()] ? -1 : +1;
            else c = o1.getKey() < o2.getKey() ? -1 : 1;
            if (lengths[o1.getKey()] == lengths[o2.getKey()])
                c = o1.getValue().length() < o2.getValue().length() ? -1 : +1;
            return c;
        }).findFirst().get().getValue()
        );
    }

    public static void main( String[] args )
    {
        List<String> inList = new ArrayList<>();
//        inList.add("FJAFJKLDSKF7JKFDJ");
//        inList.add("ASDFDSASDFDSAzxcPOIUY");
//        inList.add("qwERfgHJ123456789");
//        inList.add("FGhjKL:\"';lkqwerzxcc");
//        inList.add("qwERRfgHJJ123456789");
//        inList.add("ASDFASDFqwer432!");
//        inList.add("432!");
//        inList.add("EUIyouiepIEjhadSDJ(*Y9y9");
//        inList.add("1233AERSdfqw");
//        inList.add("ASDF11!*&+1");
//        inList.add("}*3%&2098@$2k234#@$M");
//        inList.add("wqfdSREA3321");
//        inList.add(":X:D:):DDDDDDDxDDDD:(;);];]");
//        inList.add("qweasdzxc123");
//        inList.add(" @#34$%^&)_+`1*(2567890-=\\~!");
        inList.add("iiirjjjj");
        for (int i = 0 ; i < inList.size() ; i++) {
            f(inList.get(i));
        }

    }
}
