    static void f(int n, String scene) {
        String[] lines = scene.split("\n");
        char[][] result = new char[lines[0].length()][lines.length];
        for (int i = 0; i < lines[0].length(); i++) {
            for (int j = lines.length - 1; j >= 0; j--) {
                result[i][j] = lines[j].charAt(i);
            }
        }

        Pattern patternNo = Pattern.compile("(.*\\.)([|\\\\/]+)(X$)"), patternYes = Pattern.compile("(.*\\$)([|\\\\/]+)(X$)");

        List<String> columns = new ArrayList<>(Arrays.asList(new String[result.length]));

        List<Integer> onColumns = new ArrayList<>(), offColumns = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            String currentColumn = String.valueOf(result[i]);
            Matcher matcherNo = patternNo.matcher(currentColumn);
            Matcher matcherYes = patternYes.matcher(currentColumn);
            if (matcherNo.matches() && isValidCandle(matcherNo.group(2))) {
                offColumns.add(i);
            } else if (matcherYes.matches() && isValidCandle(matcherYes.group(2))) {
                onColumns.add(i);
            } else {
                columns.set(i, currentColumn);
            }
        }

        if (onColumns.size() + offColumns.size() == 0) {
            System.out.println(":(");
        } else if (onColumns.size() > n) {
            System.out.println(n - onColumns.size());
        } else if (onColumns.size() + offColumns.size() < n) {
            System.out.println(n - onColumns.size() - offColumns.size());
        } else {
            for (Integer onColumn : onColumns) {
                columns.set(onColumn, String.valueOf(result[onColumn]));
            }
            int req = n - onColumns.size();
            for (Integer offColumn : offColumns) {
                String element = String.valueOf(result[offColumn]);
                if (req-- != 0) {
                    element = new StringBuilder().append(element).replace(element.lastIndexOf('.'), element.lastIndexOf('.') + 1, "$").toString();
                }
                columns.set(offColumn, element);
            }
            for(int i = 0;i < columns.get(0).length();i++){
                for(int j = 0; j < columns.size();j++){
                    System.out.print(columns.get(j).charAt(i));
                }
                System.out.print("\n");
            }
        }
    }

    static boolean isValidCandle(String candidate) {
        int angleCounter = 0;
        for (char c : candidate.toCharArray()) {
            if (c == '\\') {
                if (angleCounter < 1) angleCounter++;
                else return false;
            }
            if (c == '/') {
                if (angleCounter > -1) angleCounter--;
                else return false;
            }
        }
        return angleCounter == 0;
    }