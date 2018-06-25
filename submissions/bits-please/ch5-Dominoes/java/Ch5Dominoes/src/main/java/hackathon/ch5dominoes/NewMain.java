package hackathon.ch5dominoes;

import java.util.ArrayList;
import java.util.List;

public class NewMain {

    public static void main(String[] args) {
        System.out.println(f("|\\"));
    }

    enum DominoState {

        PIPE("|"),
        SLASH("/"),
        BackSlash("\\"),
        LINE("__"),
        SPACE(" ");

        String state;

        private DominoState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public static String f2(String n) {
        n = " " + n + " ";

        String n_plus1 = n;
        boolean firstTime = true;
        while (firstTime || !n_plus1.equals(n)) {
            firstTime = false;
            String tempString = n_plus1;
            n_plus1 = oneIterationChange(tempString);
            n = tempString;
        }

        return n.trim();
    }

    private static String oneIterationChange(String input) {
        List<DominoState> dominos = parseDominoString(input);

        for (int i = 0; i < dominos.size() - 3; i++) {
            changeIfPossible(dominos, i);
        }

        return dominoStatesToString(dominos);
    }

    private static void changeIfPossible(List<DominoState> dominos, int index) {
        List<DominoState> subList = dominos.subList(index, index + 3);

        for (Change ch : Change.values()) {
            if (ch.from.equals(dominoStatesToString(subList))) {
                replace(subList, ch.to);
            }
        }
    }

    private static void replace(List<DominoState> subList, String to) {
        List<DominoState> toChange = parseDominoString(to);
        for (int i = 0; i < subList.size(); i++) {
            if (i >= toChange.size()) {
                subList.set(i, null);
            } else {
                subList.set(i, toChange.get(i));
            }
        }
    }

    private static List<DominoState> parseDominoString(String input) {
        List<DominoState> dominos = new ArrayList<>();
        String buffer = "";
        for (char c : input.toCharArray()) {
            buffer += c;
            for (DominoState ds : DominoState.values()) {
                if (ds.getState().equals(buffer)) {
                    dominos.add(ds);
                    buffer = "";
                }
            }
        }
        return dominos;
    }

    private static String dominoStatesToString(List<DominoState> dominos) {
        StringBuilder b = new StringBuilder();
        for (DominoState s : dominos) {
            if (null != s) {
                b.append(s.getState());
            }
        }
        return b.toString();
    }

    public static String f(String n) {
        n = " " + n + " ";

        String n_plus1 = n;
        boolean firstTime = true;
        while (firstTime || !n_plus1.equals(n)) {
            firstTime = false;
            String tempString = n_plus1;
            n_plus1 = change(tempString);
            n = tempString;
        }

        return n.trim();
    }

    private static String change(String input) {
        for (Change change : Change.values()) {
            if (input.contains(change.from)) {
                String replaced = replaceFirst(input, change.from, change.to);
                return replaced;
            }
        }
        return input;
    }

    private static String replaceFirst(String input, String from, String to) {
        return input.substring(0, input.indexOf(from))
                + to
                + input.substring(input.indexOf(from) + from.length());
    }

    enum Change {

//        C11("/| |\\", "/__\\\\"), //5
//        C10("/||\\", "//\\\\"), //4
//        C5("/ \\", "__\\"), //4
        C8l("__|\\", "__\\\\"),//3
        C8r("/|__", "//__"),//3

//        C8xa("| \\\\", "|__\\"), //4

        C4r("/| ", "/__"), //3
        
        C6ra("/ \\", "__\\"),//3
        C6rb("| \\", "|__"),//3
        C6rc("/ |", "__|"),//3
        C6rd("/||", "//|"),//3
        C6re("// ", "/__"),//3
        
        C6rf("/ ", "__"),//3
        
        C6r("/||", "//|"),//3
        C6l("||\\", "|\\\\"),//3

        C7r("\\|\\", "\\\\\\"),//3
        C7l("/|/", "///"),//3

        
        C4l(" |\\", "__\\"), //3

        C1l("/ ", "__"), //2
        C1r(" \\", "__"), //2
        ;

        String from;
        String to;

        private Change(String from, String to) {
            this.from = from;
            this.to = to;
        }

    }
}
