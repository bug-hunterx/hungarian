//public class Challenge8 {
    static void f(String input, int n, int width) {
        String[] sorted = new String[getArrayLength(input, n, width)];
        for (int i = 0; i < sorted.length; i++) {
            String word = input.substring(i * width, Math.min((i + 1) * width, input.length()));
            sorted[i] = word;
        }

        String rowFormat = buildRowFormat(n, width);

        int rows = (sorted.length + n - 1) / n;
        for (int i = 0; i < rows; i++) {
            String[] row = new String[n];
            for (int j = 0; j < n; j++) {
                int i1 = i + j * rows;
                row[j] = sorted.length > i1 ? sorted[i1] : "";
            }
            System.out.println(String.format(rowFormat, row));
        }
        //        System.out.println("/----");
    }

    private static String buildRowFormat(final int n, final int width) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("%-" + width + "." + width + "s|");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private static int getArrayLength(final String input, final int n, final int width) {
        return (int) Math.max(1, Math.ceil(1.0 * input.length() / width));
    }

//    public static void main(String[] args) {
        //        f("Results, Relentlessly", 3, 4);
        //        f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5);
        //        f("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 3, 65);
        //        f("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, 1);
//        f("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 3, 4);
        //        f("1212", 2, 3);
        //        f("", 3, 3);
//    }
//}
//