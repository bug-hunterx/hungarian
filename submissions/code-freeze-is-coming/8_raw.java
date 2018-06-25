static void f(String input, int n, int width) {
        int cells = 0;
        for (int i = 0; i < input.length(); i += width) {
            cells++;
        }
        int rows = cells % n > 0 ? (cells / n) + 1 : (cells / n);
        String[][] matrix = new String[rows][n];
        int begin = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rows; j++) {
                int end = begin + width > input.length() ? input.length() : begin + width;

                matrix[j][i] = input.substring(begin, end);
                if (matrix[j][i].length() < width ) {
                    String init = matrix[j][i];
                    for (int k = 0; k < width - matrix[j][i].length(); k++) {
                        init += " ";
                    }
                    matrix[j][i] = init;
                }
                matrix[j][i] +=  "|";
                begin = end;
                if (i == n - 1) {
                    String init = matrix[j][i].replace("|", "");
                    matrix[j][i] = init + "\n";
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                result += matrix[i][j];
            }
        }
        System.out.println(result);
    }