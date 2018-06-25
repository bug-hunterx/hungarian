public static void f(String input) {
        System.out.print( sortToKeyboardOrder(selectShortest(charsNotInRow(input))) );
        }

static String keyboard[] = {
        "`1234567890-=~!@#$%&*()_+",
        "qwertyuiop[]\\QWERTYUIOP{}|",
        "asdfghjkl;'ASDFGHJKL:\"",
        "zxcvbnm,./ZXCVBNM<>?"
        };

static List<String> charsNotInRow(String input) {

        List<String> result = new LinkedList<>();

        for (int keyboardRowCheckedAgainst = 0; keyboardRowCheckedAgainst < 4; keyboardRowCheckedAgainst++) {

        String remainingCharacters = removeCharacters(input, keyboard[keyboardRowCheckedAgainst]);

        for (int actualRow = 0; actualRow < 4; actualRow++) {
        if (keyboardRowCheckedAgainst != actualRow) {

        String charsInThisRow = "" + actualRow;

        for (char c : remainingCharacters.toCharArray()) {
        if (containsChar(keyboard[actualRow], c)) {
        charsInThisRow += c;
        }
        }

        if (charsInThisRow.length() > 1) result.add(charsInThisRow);

        }
        }

        }

        return result;
        }

static String removeCharacters(String input, String characters) {

        String result = "";
        for (char c : input.toCharArray()) {
        if (!containsChar(characters, c)) result += c;
        }

        return result;
        }

static boolean containsChar(String input, char c) {
        return charIndex(input, c) >= 0;
        }

private static int charIndex(String input, char c) {
        return input.indexOf(c);
        }

static int getShortestLength(List<String> input) {

        int minLength = 99;

        for (String row : input) {
        int size = row.length();
        if (minLength > size && size != 0) {
        minLength = size;
        }
        }

        return minLength;
        }

static String selectShortest(List<String> input) {

        List<String> sorted = getShortest(input);

        if (sorted.size() > 1) {

        sorted = getShortest(removeDuplicateCharacters(sorted));

        }

        return sorted.get(0).substring(1);

        }

private static List<String> removeDuplicateCharacters(List<String> sorted) {
        List<String> result = new LinkedList<>();
        for (String s : sorted) {
        Set<Character> set = new LinkedHashSet<Character>();
        for (int i = 1; i < s.length(); i++) {
        set.add(s.charAt(i));
        }

        String processed = ""+s.charAt(0);

        for (char c : set) {
        processed += c;
        }

        result.add(processed);
        }

        return result;
        }

private static List<String> getShortest(List<String> input) {
        return input.stream().filter(s -> s.length() == getShortestLength(input)).sorted().collect(Collectors.toList());
        }

static String sortToKeyboardOrder(String input) {

        String result = "";

        for (int row = 0; row < 4; row ++ ) {

        for (char c : keyboard[row].toCharArray()) {
        int index = charIndex(input, c);
        if (index >=0 ) {
        result += input.charAt(index);
        }
        }

        }

        return result;
        }
