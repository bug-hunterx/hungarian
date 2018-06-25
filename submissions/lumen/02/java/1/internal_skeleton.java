
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;


public class internal_skeleton {

    private static final Map<Integer, String> KEYBOARD_MAPPING = new HashMap<Integer, String>() {{
        put(0, "1234567890-=!@#$%^ &*()_+");
        put(1, "qwertyuiop[]\\QWERTYUIOP{}|");
        put(2, "asdfghjkl;ASDFGHJKL:");
        put(3, "zxcvbnm,./ZXCVBNM<>?");
    }};

    public String f(String input) {
        HashMap<Integer, String> charsByRows = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            for (Map.Entry<Integer, String> keyboardRow : KEYBOARD_MAPPING.entrySet()) {

                String rowKeys = keyboardRow.getValue();
                Integer rowIndex = keyboardRow.getKey();

                if (rowKeys.indexOf(currentChar) > -1) {
                    String uniqueCharsOnRow = charsByRows.get(rowIndex);
                    uniqueCharsOnRow += currentChar;
                    charsByRows.put(rowIndex, uniqueCharsOnRow.replace("null", ""));
                }
            }
        }

        String shortestString = Collections.min(charsByRows.values(), new Comparator<String>() {
            @Override
            public int compare(final String o1, final String o2) {
                return ((Integer) getUniqueChars(o1).length()).compareTo(getUniqueChars(o2).length());
            }
        });

        String shortestStringWithUniqueChars = getUniqueChars(shortestString);
        String order = KEYBOARD_MAPPING.get(charsByRows.entrySet().stream().filter(entry -> entry.getValue().equals(shortestString)).findFirst().get().getKey());

        Character[] chars = shortestStringWithUniqueChars.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(chars, new Comparator<Character>() {
            @Override
            public int compare(final Character o1, final Character o2) {
                return order.indexOf(o1) - order.indexOf(o2);
            }
        });


        String result = "";

        for (Character c : chars)
            result += c.toString();


        return result;
    }

    private String getUniqueChars(final String input) {
        String shortestStringWithUniqueChars = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (shortestStringWithUniqueChars.indexOf(currentChar) == -1) {
                shortestStringWithUniqueChars += currentChar;
            }
        }
        return shortestStringWithUniqueChars;
    }
}
