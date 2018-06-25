    private static final String STANDING = "|";
    private static final String LEFT_TILTED = "\\";
    private static final String RIGHT_TILTED = "/";
    private static final String FALLEN = "_";
    private static final String EMPTY_SPACE = " ";

    public static void f(String input) {
        String inputWithSpaceToFall = " " + input + " ";
        String rightTilted = tiltRight(inputWithSpaceToFall);
        String leftTilted = tiltLeft(rightTilted);
        System.out.println(leftTilted.trim());
    }

    private static String tiltRight(String input) {
            String result = input;
            for (int i = 1; i < result.length() -1 ; i++) {
            String previousChar = String.valueOf(result.charAt(i-1));
            String currentChar = String.valueOf(result.charAt(i));
            String nextChar = String.valueOf(result.charAt(i+1));
            if (previousChar.equals(RIGHT_TILTED) && currentChar.equals(STANDING)) {
            if (nextChar.equals(EMPTY_SPACE)) {
            result = replaceCharInString(result, FALLEN, i);
            result = replaceCharInString(result, FALLEN, i+1);
            }
            else if (canTiltRight(result.substring(i+1))) {
            result = replaceCharInString(result, RIGHT_TILTED, i);
            }
            } else if (currentChar.equals(RIGHT_TILTED) && nextChar.equals(EMPTY_SPACE)) {
            result = replaceCharInString(result, FALLEN, i);
            result = replaceCharInString(result, FALLEN, i+1);
            }
            }
            return result;
            }

    private static boolean canTiltRight(final String input) {
            for(int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));
            if (currentChar.equals(EMPTY_SPACE) ||currentChar.equals(RIGHT_TILTED)) {
            return true;
            } else if (currentChar.equals(LEFT_TILTED) || currentChar.equals(FALLEN)) {
            return false;
            }
            }
            return true;
            }

    private static String tiltLeft(final String input) {
            String result = input;
            for (int i = result.length()-2; i > 0; i--) {
            String previousChar = String.valueOf(result.charAt(i-1));
            String currentChar = String.valueOf(result.charAt(i));
            String nextChar = String.valueOf(result.charAt(i+1));
            if (nextChar.equals(LEFT_TILTED) && currentChar.equals(STANDING)) {
            if (previousChar.equals(EMPTY_SPACE)) {
            result = replaceCharInString(result, FALLEN, i);
            result = replaceCharInString(result, FALLEN, i-1);
            }
            else if(canTiltLeft(result.substring(0, i))) {
            result = replaceCharInString(result, LEFT_TILTED, i);
            }
            } else if (currentChar.equals(LEFT_TILTED) && previousChar.equals(EMPTY_SPACE)) {
            result = replaceCharInString(result, FALLEN, i);
            result = replaceCharInString(result, FALLEN, i-1);
            }
            }
            return result;
            }

    private static boolean canTiltLeft(final String input) {
            for(int i = input.length()-1; i >= 0; i--) {
            String currentChar = String.valueOf(input.charAt(i));
            if (currentChar.equals(EMPTY_SPACE) ||currentChar.equals(LEFT_TILTED)) {
            return true;
            } else if (currentChar.equals(RIGHT_TILTED) || currentChar.equals(FALLEN)) {
            return false;
            }
            }
            return true;
            }

    private static String replaceCharInString(String input, String newChar, int index) {
            return input.substring(0,index)+newChar+input.substring(index+1);
            }
