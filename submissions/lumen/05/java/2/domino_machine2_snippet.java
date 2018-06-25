    static String STANDING = "|";
    static String LEFT_TILTED = "\\";
    static String RIGHT_TILTED = "/";
    static String FALLEN = "_";
    static String EMPTY_SPACE = " ";

    static String result = "";

    static void f(String input) {
        nextFrame(" " + input + " ", true, 0, false);
        System.out.println(result.trim());
    }

    static void nextFrame(String input, boolean normalDirection, int frameNo, boolean hasChangedBefore) {
        boolean hasChanged = false;

        for (int i = 1; i < input.length() - 1; i++) {
            String currentDomino = String.valueOf(input.charAt(i));
            String previousDomino = String.valueOf(input.charAt(i - 1));
            String nextDomino = String.valueOf(input.charAt(i + 1));

            if (STANDING.equals(currentDomino) && RIGHT_TILTED.equals(previousDomino) && !LEFT_TILTED.equals(nextDomino)) {
                input =  replaceCharInString(input, RIGHT_TILTED, i);
                hasChanged = true;
            }
            if (RIGHT_TILTED.equals(currentDomino) && EMPTY_SPACE.equals(nextDomino)) {
                input = replaceCharInString(input, FALLEN, i);
                input = replaceCharInString(input, FALLEN, i+1);
                hasChanged = true;
            }
        }

        if (hasChanged || hasChangedBefore || frameNo<1)
            nextFrame(reverse(input), !normalDirection, frameNo+1, hasChanged);
        else {
            result = normalDirection ? input : reverse(input);
        }

    }

    static String reverse(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            String current = String.valueOf(input.charAt(i));
            builder.append(LEFT_TILTED.equals(current) ? RIGHT_TILTED : RIGHT_TILTED.equals(current) ? LEFT_TILTED : current);
        }
        return builder.toString();
    }

    static String replaceCharInString(String input, String newChar, int index) {
        return input.substring(0, index) + newChar + input.substring(index + 1);
    }

