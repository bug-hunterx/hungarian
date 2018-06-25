public static void f(String input) {
        List<Character> dominoAfterDeath = new ArrayList<>();
        char[] first = input.toCharArray();
        char[] old = new char[1];
        while(!Arrays.equals(old, first)){
        old = Arrays.copyOf(first, first.length);
        for (int i = 0; i < first.length; i++) {
        if (first[i] == '/') {
        handleRightTitled(first, i, dominoAfterDeath);
        } else if (first[i] == ' ') {
        dominoAfterDeath.add(' ');
        } else if (first[i] == '|') {
        handleStanding(first, i, dominoAfterDeath);
        } else if (first[i] == '\\') {
        handleLeftTitled(first, i, dominoAfterDeath);
        } else if (first[i] == '_') {
        dominoAfterDeath.add('_');
        }
        }
        first = new char[dominoAfterDeath.size()];
        for (int i = 0; i < dominoAfterDeath.size(); i++) {
        first[i] = dominoAfterDeath.get(i);
        }
        dominoAfterDeath.clear();
        }
        System.out.print(new String(first));
        }

private static void handleLeftTitled(char[] first, int i, List<Character> dominoAfterDeath) {
        //there is only one \
        if (i == 0) {
        dominoAfterDeath.add('_');
        removeSpaceLeft(first, i, dominoAfterDeath);
        return;
        } else {
        // _\
        if (i - 1 >= 0 && first[i - 1] == '_') {
        dominoAfterDeath.add('\\');
        return;
        }
        //  \
        if (i - 1 >= 0 && first[i - 1] == ' ') {
        dominoAfterDeath.add('_');
        removeSpaceLeft(first, i, dominoAfterDeath);
        return;
        }
        //  \\
        if (i - 1 >= 0 && first[i - 1] == '/') {
        dominoAfterDeath.add('\\');
        return;
        }
        if (i - 1 >= 0 && first[i - 1] == '\\') {
        dominoAfterDeath.add('\\');
        return;
        }
        //  |\
        if (i - 1 >= 0 && first[i - 1] == '|') {
        dominoAfterDeath.add('\\');
        return;
        }
        // \\
        if (i + 1 < first.length && first[i + 1] == '\\') {
        dominoAfterDeath.add('_');
        removeSpaceLeft(first, i, dominoAfterDeath);
        return;
        }
        }
        }

private static void removeSpace(char[] first, int i, List<Character> dominoAfterDeath) {
        if (i + 1 < first.length && first[i + 1] == ' ') {
        first[i + 1] = '_';
        } else {
        dominoAfterDeath.add('_');
        }
        }

private static void removeSpaceLeft(char[] first, int i, List<Character> dominoAfterDeath) {
        if (i - 1 > 0 && first[i - 1] == ' ') {
        dominoAfterDeath.remove(i - 1);
        dominoAfterDeath.add(i - 1, '_');
        } else {
        dominoAfterDeath.add('_');
        }
        }

private static void handleStanding(char[] first, int i, List<Character> dominoAfterDeath) {
        if (i == 0 && first.length == 1) {
        dominoAfterDeath.add('|');
        return;
        } else {
        // \|
        if (i - 1 >= 0 && first[i - 1] == '\\') {
        // \|\
        if (i + 1 < first.length && first[i + 1] == '\\') {
        dominoAfterDeath.add('\\');
        return;
        }
        // _|\
        if (i - 1 > 0 && first[i - 1] == '_') {
        dominoAfterDeath.add('\\');
        return;
        }
        //  |\
        if (i + 1 < first.length && first[i + 1] == ' ') {
        dominoAfterDeath.add('\\');
        return;
        }
        }
        // /|
        if (i - 1 >= 0 && first[i - 1] == '/') {
        if (i + 1 < first.length && first[i + 1] == '\\') {
        dominoAfterDeath.add('|');
        return;
        } else {
        dominoAfterDeath.add('/');
        return;
        }
        }
        // |\
        if (i + 1 < first.length && first[i + 1] == '\\') {
        dominoAfterDeath.add('\\');
        return;
        } else {
        // _|_ |
        dominoAfterDeath.add('|');
        return;
        }
        }
        }


private static void handleRightTitled(char[] first, int i, List<Character> dominoAfterDeath) {
        // / --> _
        if ((i == 0 && first.length == 1) || i == first.length - 1) {
        dominoAfterDeath.add('_');
        removeSpace(first, i, dominoAfterDeath);
        return;
        } else {
        // /\
        if (i + 1 < first.length && first[i + 1] == '\\') {
        dominoAfterDeath.add('/');
        return;
        }
        if (i + 1 < first.length && first[i + 1] == '/') {
        dominoAfterDeath.add('/');
        return;
        }
        // /| /|\ /
        if (i + 1 < first.length  && first[i + 1] == '|') {
        dominoAfterDeath.add('/');
        return;
        }
        // /_
        if (i + 1 < first.length  && first[i + 1] == '_') {
        dominoAfterDeath.add('/');
        return;
        }
        // if |.
        if (i + 1 < first.length  && first[i + 1] == ' ') {
        dominoAfterDeath.add('_');
        removeSpace(first, i, dominoAfterDeath);
        return;
        }
        // /\
        if (i == first.length) {
        dominoAfterDeath.add('_');
        removeSpace(first, i, dominoAfterDeath);
        return;
        }
        }
        }