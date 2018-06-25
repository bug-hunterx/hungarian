
import java.util.*;


public class internal_skeleton3 {

    private static final Map<Integer, String> KEYBOARD_MAPPING = new HashMap<Integer, String>() {{
        put(0, "1234567890-=!@#$%&*()_+");
        put(1, "qwertyuiop[]\\QWERTYUIOP{}|");
        put(2, "asdfghjkl;ASDFGHJKL:");
        put(3, "zxcvbnm,./ZXCVBNM<>?");
    }};

    public static String f(String input) {

        Map<Integer, String> charsByRows = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            for (Map.Entry<Integer, String> currentKeyBoardRow : KEYBOARD_MAPPING.entrySet()) {

                String rowKeys = currentKeyBoardRow.getValue();
                Integer rowIndex = currentKeyBoardRow.getKey();

                if (rowKeys.indexOf(currentChar) > -1) {
                    String charsOnRow = charsByRows.get(rowIndex);
                    charsOnRow += currentChar;
                    charsByRows.put(rowIndex, charsOnRow.replace("null", ""));
                }
            }
        }

        List<Map.Entry<Integer, String>> leastFrequentRows = new ArrayList<>();

        for (Map.Entry<Integer, String> charsOnRow : charsByRows.entrySet()) {
            if (leastFrequentRows.isEmpty() || leastFrequentRows.get(0).getValue().length() > charsOnRow.getValue().length()) {
                leastFrequentRows.clear();
                leastFrequentRows.add(charsOnRow);
            } else if (leastFrequentRows.get(0).getValue().length() == charsOnRow.getValue().length()) {
                leastFrequentRows.add(charsOnRow);
            }
        }

        List<Map.Entry<Integer, String>> leastUniqueRows = new ArrayList<>();

        for (Map.Entry<Integer, String> leastFrequentRow : leastFrequentRows) {
            if (leastUniqueRows.isEmpty() || getUniqueChars(leastUniqueRows.get(0).getValue()).length() > getUniqueChars(leastFrequentRow.getValue()).length()) {
                leastUniqueRows.clear();
                leastUniqueRows.add(new AbstractMap.SimpleEntry<>(leastFrequentRow.getKey(), getUniqueChars(leastFrequentRow.getValue())));
            } else if (leastUniqueRows.get(0).getValue().length() == leastFrequentRow.getValue().length()) {
                leastUniqueRows.add(leastFrequentRow);
            }
        }

        Map.Entry<Integer, String> topMostUnique = null;
        for (Map.Entry<Integer, String> leastUniqueRow : leastUniqueRows) {
            if (topMostUnique == null || topMostUnique.getKey() > leastUniqueRow.getKey()) {
                topMostUnique = leastUniqueRow;
            }
        }


        int keyBoardRow = 0;
        for (Map.Entry<Integer, String> currentRow : KEYBOARD_MAPPING.entrySet()) {
            if (currentRow.getValue().contains(String.valueOf(topMostUnique.getValue().charAt(0)))) {
                keyBoardRow = currentRow.getKey();
            }
        }
        String order = KEYBOARD_MAPPING.get(keyBoardRow);

        Character[] chars = topMostUnique.getValue().chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(chars, (o1, o2) -> order.indexOf(o1) - order.indexOf(o2));


        String result = "";

        for (Character c : chars)
            result += c.toString();


        return result;
    }

    private static String getUniqueChars(final String input) {
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
