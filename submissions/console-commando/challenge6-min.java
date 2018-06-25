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