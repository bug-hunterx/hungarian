import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Exec8 {

    public static void main(String[] args) {

        //        Resu|.Rel|essl
        //        lts,|entl|y...
        f("Results, Relentlessly", 3, 4);
        System.out.println();

        //        This.|t.wit|unnee|.....
        //        is.a.|h,.a,|ded,.|..spa
        //        longe|.lot,|comma|ces..
        //        r.tex|.of,.|..And|.....
        f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5);
        System.out.println();
        f("0", 3, 4);
        System.out.println();
        f("0", 3, 1);
        System.out.println();
        f("", 1, 1);
        System.out.println();
        f("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZˇ", 3, 1);
        System.out.println();
        f("0123456789abcdefghijklmhnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZˇ", 3, 1);
        System.out.println();

        f("01234567890123456789012345678901234567890123456789012345678912", 3, 4);
        System.out.println();
        f("012345678901234567890123456789012345678901234567890123456789123", 3, 4);
        System.out.println();
        f("0123456789012345678901234567890123456789012345678901234567891234", 3, 4);
        System.out.println();
        f("01234567890123456789012345678901234567890123456789012345678912344", 3, 4);
        System.out.println();

        f("01234567890123456789012345678901234567890123456789012345678912", 4, 3);
        System.out.println();
        f("012345678901234567890123456789012345678901234567890123456789123", 4, 3);
        System.out.println();
        f("0123456789012345678901234567890123456789012345678901234567891234", 4, 3);
        System.out.println();
        f("01234567890123456789012345678901234567890123456789012345678912344", 4, 3);
    }

    static void f(String s, int n, int width) {
        int x = 0, y = 0, yMax;
        if ((s.length() % (width * n) == 0)) {
            yMax = s.length() / (width * n);
        } else {
            yMax = s.length() / (width * n) + 1;
        }
        String[][] r = new String[n][yMax];
        for (int i = 0; i < s.length(); ) {
            if (i + width > s.length()) {
                r[x][y] = s.substring(i, s.length());
            } else {
                r[x][y] = s.substring(i, i + width);
            }
            if (y == yMax - 1) {
                y = 0;
                x++;
            } else {
                y++;
            }
            i += width;
        }
        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < n; j++) {
                if (r[j][i] == null) {
                    r[j][i] = " "; //new String(new char[width]).replace('\0', '_');
                }
                  if (r[j][i].length() < width) {
                      String sw = "                    ";
//                    for (int z=0;z < width-r[j][i].length();z++){
//                        r[j][i] += " ";
//                    }
                        r[j][i] += sw.substring(20-(width-r[j][i].length()));
                }
                if (j + 1 < n) {
                    System.out.print(r[j][i].concat("|").concat("(" + r[j][i].length() + ")"));
//                    System.out.print(r[j][i].concat("|"));
                } else {
                    System.out.println(r[j][i].concat("(" + r[j][i].length() + ")"));
//                    System.out.println(r[j][i]);
                    j = 0;
                    break;
                }
            }
        }
    }
}
