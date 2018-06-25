package hu.epam.hackaton.noteamfoundexception.theApplication;

public class C8Runnable {

    static void f(String s, int c, int w) {
        int l = (int) Math.ceil((double)s.length() / (c * w));
        
        String t = String.format("%-"+l*c*w+"s", s);
        
        String[][] m = new String[l][c];

        for (int j = 0; j < c; j++) {
            for (int i = 0; i < l; i++) {
                m[i][j] = t.substring(i * w + j * l * w, i * w + j * l * w + w);
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j]);
                System.out.print(j<c-1?"|":"\n");
            }
        }
    }

    public static void main(String[] args) {
        f("a", 10, 10);
        f("1234567890", 1, 1);
        f("1234567890", 1, 2);
        f("1234567890", 1, 3);
        f("1234567890", 2, 1);
        f("1234567890", 2, 2);
        f("1234567890", 2, 3);
        f("abcdefghijklmno", 3, 2);
        f("Results, Relentlessly", 3, 4);
        f("This is a longer text with, a, lot, of, unneeded, comma. And    spaces.", 4, 5);
        f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 100, 4);
    }
}
