
public class domino_machine3 {

    static String STANDING = "|";
    static String LEFT_TILTED = "\\";
    static String RIGHT_TILTED = "/";
    static String FALLEN = "_";
    static String EMPTY_SPACE = " ";

    static String result = "";


    static String f(String input) {
        nextFrame(" " + input + " ");
        return result.substring(1, result.length() - 1);
    }

    static void nextFrame(final String input) {
        StringBuilder currentFrame = new StringBuilder();

        boolean skipNext = false;
        for (int i = 1; i < input.length() - 1; i++) {
            String currentDomino = String.valueOf(input.charAt(i));
            String previousDomino = String.valueOf(input.charAt(i - 1));
            String nextDomino = String.valueOf(input.charAt(i + 1));

            if (STANDING.equals(currentDomino)) {
                if (RIGHT_TILTED.equals(previousDomino) && !LEFT_TILTED.equals(nextDomino))
                    currentFrame.append(RIGHT_TILTED);
                else if (LEFT_TILTED.equals(nextDomino) && !RIGHT_TILTED.equals(previousDomino))
                    currentFrame.append(LEFT_TILTED);
                else
                    currentFrame.append(currentDomino);

            } else if (RIGHT_TILTED.equals(currentDomino) && EMPTY_SPACE.equals(nextDomino)) {
                currentFrame.append(FALLEN);
                currentFrame.append(FALLEN);
                skipNext = true;

            } else if (LEFT_TILTED.equals(currentDomino) && EMPTY_SPACE.equals(previousDomino) && (i < 2 || (i > 1 && !RIGHT_TILTED.equals(String.valueOf(input.charAt(i - 2)))))) {
                if (currentFrame.length() > 0)
                    currentFrame.deleteCharAt(currentFrame.length() - 1);
                currentFrame.append(FALLEN);
                currentFrame.append(FALLEN);
            } else if (EMPTY_SPACE.equals(currentDomino) && skipNext) {
                skipNext = false;
            } else {
                currentFrame.append(currentDomino);
            }
        }

        if (currentFrame.toString().trim().equals(input.trim()))
            result = input;
        else
            nextFrame(" " + currentFrame.toString() + " ");

    }

}
