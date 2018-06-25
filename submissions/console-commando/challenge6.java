import java.util.*;
import java.text.DecimalFormat;

class Challenge6 {
    final static String x = "PAID BY CARD";
    final static String y = "KEEP THE CHANGE YOU FILTY ANIMAL";
    static void f (int a) {
        String m;
        if (a < 2000) {
            m = (a % 100 == 0) ? x : y;
        } else if (a >= 2000 && a < 5000) {
            double n = (a + 499) / 500 * 500;
            double t = n - a;
            if (t == 0 || t > 1500) {
                m = x;
            } else if (t % 100 != 0) {
                m = y;
            } else {
                m = "HERE IS " + (int)n;
            }
        } else {
            double n = a * 1.1;
            a = (int)n;
            n = Math.round(a / 500f) * 500;
            double t = n - a;
            if (t == 0 || t > 1500) {
                m = x;
            } else if (t % 100 != 0) {
                m = y;
            } else {
                m = "HERE IS " + (int)n;
            }
        }
        System.out.println(m);
    }

    public static void main(String[] args) {
        // f(5100);
        System.out.println(Math.round(20 / 5f) * 5);
        System.out.println(Math.round(21 / 5f) * 5);
        System.out.println(Math.round(22 / 5f) * 5);
        System.out.println(Math.round(23 / 5f) * 5);
        System.out.println(Math.round(24 / 5f) * 5);
        System.out.println(Math.round(25 / 5f) * 5);
        System.out.println(Math.round(26 / 5f) * 5);
        System.out.println(Math.round(27 / 5f) * 5);
        System.out.println(Math.round(28 / 5f) * 5);
        System.out.println(Math.round(29 / 5f) * 5);
        System.out.println(Math.round(30 / 5f) * 5);

        System.out.println();
        System.out.println((20 + 4) / 5 * 5);
        System.out.println((21 + 4) / 5 * 5);
        System.out.println((22 + 4) / 5 * 5);
        System.out.println((23 + 4) / 5 * 5);
        System.out.println((24 + 4) / 5 * 5);
        System.out.println((25 + 4) / 5 * 5);
        System.out.println((26 + 4) / 5 * 5);
        System.out.println((27 + 4) / 5 * 5);
        System.out.println((28 + 4) / 5 * 5);
        System.out.println((29 + 4) / 5 * 5);
        System.out.println((30 + 4) / 5 * 5);
    }
}

