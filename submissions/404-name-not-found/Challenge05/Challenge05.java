public static void f(String input) {
        String[] c=input.split("");for(int i=0;i<input.length();i++) {
            if(c[i].equals("_")&&(i < input.length())){
                if(c[i+1].equals("_")){
                    c[i+1]="";
                }
            }
            if (i == 0) {
                if (c[0].equals("|") && c[1].equals("\\")) {
                    c[0] = "\\";
                } else if (c[0].equals("/") && c[1].equals("|")) {
                    for(int j = 0; j < input.length(); j++){
                        if(c[j].equals("|")) {
                            c[j] = "_";
                        } else {
                            c[j] = "/";
                        }
                    }
                    c[1] = "_";

                } else if (c[0].equals("/") && c[1].equals("\\")) {
                    c[0] = "__";
                } else if (c[0].equals("/") && c[1].equals("/") && c[2].equals(" ")) {
                    c[1] = "__";
                    c[2] = "";
                }
            } else if ((input.length() - 1) == i) {
                if (c[(input.length() - 1)].equals("|") && c[(input.length() - 2)].equals("/")) {
                    c[input.length() - 1] = "_";
                } else if (c[(input.length() - 1)].equals("\\") && c[(input.length() - 2)].equals("|")) {
                    c[input.length() - 2] = "\\";
                }
            } else {
                if (!s(c[i - 1], c[i], c[i + 1])) {
                    if (c[i].equals("/") && c[i + 1].equals("\\")) {
                        if (c[i - 1].equals("_") || (i > 1 && s(c[i - 2], c[i - 1], c[i]))) {
                            c[i] = "\\";
                        } else {
                            c[i] = "_";
                        }
                    } else if (c[i].equals("/") && c[i + 1].equals(" ")) {
                        c[i] = "_";
                    } else if (c[i].equals("\\") && c[i - 1].equals(" ")) {
                        if (!(i > 2 && c[i - 2].equals("_"))) {
                            c[i] = "_";
                        }
                    } else if(c[i].equals("|") && !(c[i-1].equals("_") || c[i+1].equals("_"))){
                        if(c[i-1].equals("/")){
                            c[i] = "_";
                        } else if (c[i+1].equals("\\")){
                            c[i] = "_";
                        }
                    } else if(c[i-1].equals("/") && c[i].equals("|") &&c[i+1].equals("|")){
                        c[i]="_";
                    } else if(c[i-1].equals("|") && c[i].equals("|") &&c[i+1].equals("\\")){
                        c[i]="_";
                    }
                }
            }
        }
        for (String s : c) {
            if (s.equals("_")) {
                s = "__";
            }
            if(s.equals(" ")){
                s = "";
            }
            System.out.print(s);
        }

    public static boolean i(String s) {
        boolean r = false;
        int length = s.length();
        String reverse = "";
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + s.charAt(i);

        if (s.equals(reverse)) {
            r = true;
        }
        return r;
    }

    public static boolean s(String l, String m, String ri) {
        boolean g = false;
        if (m.equals(l) && ri.equals("_") ||
            m.equals(ri) && l.equals("_") ||
            l.equals("_") ||
            ri.equals("_") ||
            i(l.concat(m).concat(ri))) {
            g = true;
        }
        return g;
    }
}
