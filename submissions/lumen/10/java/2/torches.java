public static void f(int n, String picture) {
        String[] lines = picture.split("\n");
        int offset = lines.length - 1;
        List<Integer> potentialColumns = new ArrayList<>();

        for (int inLineIndex = 0; inLineIndex < lines[offset].length(); inLineIndex++) {
            if ('X' == lines[offset].charAt(inLineIndex)) {
                potentialColumns.add(inLineIndex);
            }
        }

        Map<Integer, String> burninTorches = new LinkedHashMap<>();
        Map<Integer, String> unlitTorches = new LinkedHashMap<>();
        for (int potentialColumn : potentialColumns) {
            StringBuilder sb = new StringBuilder();
            sb.append('X');
            for (int lineIndex = offset - 1; lineIndex >= 0; lineIndex--) {
                try {
                    char actualChar = lines[lineIndex].charAt(potentialColumn);
                    sb.append(actualChar);
                } catch (Exception e) {
                }
            }
            String column = sb.toString();
            if (Pattern.matches("X/\\|*\\\\$.*", column) || Pattern.matches("X\\|+\\$.*", column) || Pattern.matches("X(\\||\\\\|\\/)*(\\$)", column)) {
                burninTorches.put(potentialColumn, column);
            }
            if (Pattern.matches("X/\\|*\\\\\\..*", column) || Pattern.matches("X\\|+\\..*", column) || Pattern.matches("X(\\||\\\\|\\/)*(\\.)", column)) {
                unlitTorches.put(potentialColumn, column);
            }
        }
        if (burninTorches.isEmpty() && unlitTorches.isEmpty()) {
            System.out.println(":(");
        } else if (n > burninTorches.size() + unlitTorches.size()) {
            System.out.println(n - (burninTorches.size() + unlitTorches.size()));
        } else if (n > burninTorches.size()) {
            int availableTorches = Math.min(n, unlitTorches.size());
            Iterator<Map.Entry<Integer, String>> iterator = unlitTorches.entrySet().iterator();
            for (int catchingFireIndex = 0; catchingFireIndex < availableTorches; catchingFireIndex++) {
                Map.Entry<Integer, String> entry = iterator.next();
                int lineSelector = entry.getValue().indexOf(".");
                StringBuilder sb = new StringBuilder(lines[offset - lineSelector]);
                sb.setCharAt(entry.getKey(), '$');
                lines[offset - lineSelector] = sb.toString();
            }
            for (String line : lines) {
                System.out.println(line);
            }
        } else if (n <= burninTorches.size()) {
            System.out.println(n - burninTorches.size());
        }
    }