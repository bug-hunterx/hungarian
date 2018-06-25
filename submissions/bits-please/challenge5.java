
    public static void f(String n) {
        n = " " + n + " ";

        String n_plus1 = n;
        boolean firstTime = true;
        while (firstTime || !n_plus1.equals(n)) {
            firstTime = false;
            String tempString = n_plus1;
            n_plus1 = change(tempString);
            n = tempString;
        }

        n = n.startsWith(" ") ? n.substring(1) : n;
        n = n.endsWith(" ") ? n.substring(0, n.length() - 1) : n;

        System.out.print(n);
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

        C1l("/ ", "__"), //2
        C1r(" \\", "__"), //2

        C11("/| |\\", "/__\\\\"), //5
		
        C10("/||\\", "//\\\\"), //4
        C5("/ \\", "__\\"), //4
        
        C8l("__|\\", "__\\\\"),//4
        C8r("/|__", "//__"),//4
		
        C6r("/||", "//|"),//3
        C6l("||\\", "|\\\\"),//3
        
        C7r("\\|\\", "\\\\\\"),//3
        C7l("/|/", "///"),//3
                
        C4l(" |\\", "__\\"), //3
        C4r("/| ", "/__"), //3
		;

        String from;
        String to;

        private Change(String from, String to) {
            this.from = from;
            this.to = to;
        }

    }