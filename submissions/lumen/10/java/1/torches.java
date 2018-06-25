public static void f(int n, String picture) {
        String[] lines = picture.split("\n");
        int places = lines[lines.length - 1].length();
        Set<Integer> candlesToLight = new HashSet<>();
        Set<Integer> candlesLight = new HashSet<>();
        for (int i = 0; i < places; i++) {

            String candleType = hasCandleToLight(i, lines);
            if ("$".equals(candleType)) {
                candlesLight.add(i);
            } else if (".".equals(candleType)) {
                candlesToLight.add(i);
            }

        }
        if (candlesLight.isEmpty() && candlesToLight.isEmpty()) {
            System.out.println(":(");
        } else if (n > candlesToLight.size() + candlesLight.size()) {
            System.out.println((n - (candlesToLight.size() + candlesLight.size())));
        } else if (n < candlesLight.size()) {
            System.out.println((n - candlesLight.size()));
        } else {
            int deficit = Math.min(n - candlesLight.size(), candlesToLight.size());
            Iterator<Integer> it = candlesToLight.iterator();
            while (deficit != 0) {
                Integer next = it.next();
                for (int j = lines.length - 2; j >= 0; j--) {
                    if (".".equals(lines[j].substring(next, next + 1))) {
                        StringBuilder sb = new StringBuilder(lines[j]);
                        sb.setCharAt(next, '$');
                        lines[j] = sb.toString();
                        deficit--;
                        if(deficit ==0) {
                            break;
                        }
                    }
                }
            }
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }

    private static String hasCandleToLight(int i, String[] lines) {
        if (hasBase(i, lines)) {
            int numberOfLeft = 0;
            int numberOfRight = 0;
            int numberOfStraight = 0;
            int lineNumber = lines.length - 2;
            String previous = null;
            while (lineNumber >= 0 && i <= lines[lineNumber].length() - 1 && Arrays.asList("\\", "|", "/").contains(lines[lineNumber].substring(i, i + 1))) {
                if ("\\".equals(lines[lineNumber].substring(i, i + 1)) && !"\\".equals(previous)) {
                    numberOfLeft++;
                    previous = "\\";
                } else if ("/".equals(lines[lineNumber].substring(i, i + 1)) && !"/".equals(previous)) {
                    numberOfRight++;
                    previous = "/";
                } else {
                    numberOfStraight++;
                    previous = "|";
                }
                lineNumber--;
            }
            if (lineNumber >= 0 && i <= lines[lineNumber].length() - 1 && numberOfLeft == numberOfRight && (numberOfLeft > 0 || numberOfStraight > 0)) {
                if (Arrays.asList(".", "$").contains(lines[lineNumber].substring(i, i + 1))) {
                    return lines[lineNumber].substring(i, i + 1);
                }
            }
        }
        return null;
    }

    private static boolean hasBase(int i, String[] lines) {
        return "X".equalsIgnoreCase(lines[lines.length - 1].substring(i, i + 1));
    }