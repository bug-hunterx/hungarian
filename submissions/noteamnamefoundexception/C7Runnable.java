package hu.epam.hackaton.noteamfoundexception.theApplication;

public class C7Runnable {

    static void f(String b, int c) {
        String[] fl = b.split("\n");
        int l = fl.length;

        int[][] q = new int[l][l];

        int i = l;
        for (String f : fl) {
            --i;
            if (!"".equals(f)) {
                for (String p : f.split("\\|")) {
                    int n = Integer.parseInt(p.split(":")[1]);
                    n = n > 3 ? n - 1 : n;
                    q[i][n] = Integer.parseInt(p.split(":")[0]);
                }
            }
        }

        StringBuffer e = new StringBuffer();

        int f = 0;
        int d = 1;
        int s = 0;

        boolean t = 1 == 0;

        while (!t) {
            boolean st = s == 0 || e.indexOf(String.valueOf(f)) != -1;
            e = clearElevator(f, e);

            if (f == l - 1 || (f == 0 && s != 0))
                d = -d;

            if (st) {
                s++;
                fillElevator(d, f, e, q[f]);
            }

            if (e.length() == 0) {
                d = -d;
                fillElevator(d, f, e, q[f]);
            }

            f += d;

            t = e.length() >= c || e.length() == 0;
        }

        s--;
        f = f - d;
        if (f > 3)
            f++;
        if (e.length() >= c) {
            System.out.println("polite after " + s + " stops at " + f
                    + " floor");
        } else {
            System.out.println("lonely after " + s + " stops at " + f
                    + " floor");
        }
    }

    private static StringBuffer clearElevator(int f, StringBuffer e) {
        return new StringBuffer(e.toString().replaceAll(String.valueOf(f), ""));
    }

    private static void fillElevator(int d, int f, StringBuffer e, int[] q) {
        for (int i = 0; i < q.length; i++) {
            if ((d > 0 && i > f) || (d < 0 && i < f)) {
                for (int j = 0; j < q[i]; j++) {
                    e.append(i);
                }
                q[i] = 0;
            }
        }
    }

    private static void printE(StringBuffer e) {
        System.out.print("Elevator (" + e.length() + "): ");
        System.out.println(e.toString());
    }

    public static void main(String args[]) {
        f("4:2|1:5|2:0\n1:1|2:0\n2:0\n1:0\n1:5|3:6|1:0\n1:1|1:3|2:5", 11);
        f("1:0|1:1\n3:2|5:0\n1:1|2:2", 6);
        f("2:1|3:2\n1:0|1:1\n3:2|5:0\n1:1|2:2", 10);
        f("2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5",
                9);
        f("2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5",
                2);
        f("2:0\n\n\n\n1:5", 2);
        f("1:3\n1:5|1:2\n1:3|1:1\n1:2|1:0\n1:1", 2);
        f("1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2", 2);
    }

    public static void printQ(int l, int[][] q) {
        System.out.println("Queue: ");
        for (int j = l - 1; j >= 0; j--) {
            System.out.print("  From floor " + j + ": ");
            for (int k = 0; k < l; k++) {
                System.out.print(q[j][k]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
