
public class domino_machine3_min {

    static String S = "|";
    static String L = "\\";
    static String R = "/";
    static String F = "_";
    static String E = " ";

    static String X = "";


    static void f(String i) {
        nextFrame(" "+i+" ");
        System.out.println(X.substring(1,X.length()-1));
    }

    static void nextFrame(String t) {
        StringBuilder r=new StringBuilder();
        boolean q = false;
        for (int i = 1; i < t.length() - 1; i++) {
            String w = String.valueOf(t.charAt(i));
            String s = String.valueOf(t.charAt(i - 1));
            String f = String.valueOf(t.charAt(i + 1));

            if (S.equals(w)) {
                if (R.equals(s) && !L.equals(f))
                    r.append(R);
                else if (L.equals(f) && !R.equals(s))
                    r.append(L);
                else
                    r.append(w);

            } else if (R.equals(w) && E.equals(f)) {
                r.append(F);
                r.append(F);
                q = true;

            } else if (L.equals(w) && E.equals(s) && (i < 2 || (i > 1 && !R.equals(String.valueOf(t.charAt(i - 2)))))) {
                if (r.length() > 0)
                    r.deleteCharAt(r.length() - 1);
                r.append(F);
                r.append(F);
            } else if (E.equals(w) && q) {
                q = false;
            } else {
                r.append(w);
            }
        }

        if (r.toString().trim().equals(t.trim()))
            X=t;
        else
            nextFrame(" "+r.toString() + " ");

    }

}
