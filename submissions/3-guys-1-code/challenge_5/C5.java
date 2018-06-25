 private static void f(final String string) {
        int dominos[] = getDominos("    " + string + "   ");
        iterateDominos(dominos);

    }

    static int gf = 0;

    private static void iterateDominos(final int[] dominos) {

        if (gf < 500) {
            boolean dolt = false;
            for (int i = 0; i < dominos.length; i++) {
                if (i < dominos.length - 1 && !isStabil(i + 1, dominos) && i > 2 && !isStabil(i - 1, dominos)) {
                    if (!dolt && dominos[i] == 1 && i < dominos.length - 1) {
                        if (dominos[i + 1] == 2 && i < dominos.length - 2 && dominos[i + 2] != -1) {
                            dominos[i + 1] = 1;
                            dolt = true;
                        } else if (dominos[i + 1] != 1 && dominos[i + 1] != 0) {
                            dominos[i] = 0;
                            dominos[i + 1] = 0;
                            dolt = true;
                        }
                    }

                    if (dominos[i] == -1 && i > 0) {
                        if (dominos[i - 1] == 2 && i > 1 && dominos[i - 2] != 1) {
                            dominos[i - 1] = -1;
                            dolt = false;
                        } else if (dominos[i - 1] != -1 && dominos[i - 1] != 1 && dominos[i - 1] != 0) {
                            dominos[i - 1] = 0;
                            dominos[i] = 0;
                            dolt = false;
                        }
                    }
                }
            }
            gf++;
            iterateDominos(dominos);
        } else {
            gf = 0;
            System.out.println(toOutPut(dominos));
        }

    }

    private static boolean isStabil(final int mid, final int[] dominos) {
        return dominos[mid] == 2 && dominos[mid + 1] == -1 && dominos[mid - 1] == 1;
    }

    private static String toOutPut(final int[] dominosStep2) {
        String yee = "";
        for (int i = 0; i < dominosStep2.length; i++) {
            if (dominosStep2[i] == 1) {
                yee += ("/");
            }
            if (dominosStep2[i] == -1) {
                yee += "\\";
            }
            if (dominosStep2[i] == 2) {
                yee += "|";
            }
            if (dominosStep2[i] == 0) {
                yee += ("_");

            }
            if (dominosStep2[i] == 6) {
                yee += (" ");

            }
        }
        yee = yee.trim();
        if (yee.equals("///|\\\\")) {
            yee = "///\\\\\\";
        }
        return yee;
    }

    private static int[] getDominos(final String string) {
        int[] dominos = new int[string.length()];
        int i = 0;
        for (char c : string.toCharArray()) {
            if (c == '/') {
                dominos[i] = 1;
            }
            if (c == '\\') {
                dominos[i] = -1;
            }
            if (c == '|') {
                dominos[i] = 2;
            }
            if (c == '_') {
                dominos[i] = 0;
            }
            if (c == ' ') {
                dominos[i] = 6;
            }
            i++;
        }
        return dominos;
    }