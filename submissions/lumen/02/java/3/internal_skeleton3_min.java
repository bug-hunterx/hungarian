import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class internal_skeleton3_min {

    static Map<Integer, String> K = new HashMap<Integer, String>() {{
        put(0, "1234567890-=!@#$%&*()_+");
        put(1, "qwertyuiop[]\\QWERTYUIOP{}|");
        put(2, "asdfghjkl;ASDFGHJKL:");
        put(3, "zxcvbnm,./ZXCVBNM<>?");
    }};

    static void f(String w) {

        Map<Integer, String> q = new HashMap<>();

        for (int i = 0; i < w.length(); i++) {
            char t = w.charAt(i);

            for (Map.Entry<Integer, String> currentKeyBoardRow : K.entrySet()) {

                String e = currentKeyBoardRow.getValue();
                Integer r = currentKeyBoardRow.getKey();

                if (e.indexOf(t) > -1) {
                    String z = q.get(r);
                    z += t;
                    q.put(r, z.replace("null", ""));
                }
            }
        }

        List<Map.Entry<Integer, String>> u = new ArrayList<>();

        for (Map.Entry<Integer, String> p : q.entrySet()) {
            if (u.isEmpty() || u.get(0).getValue().length() > p.getValue().length()) {
                u.clear();
                u.add(p);
            } else if (u.get(0).getValue().length() == p.getValue().length()) {
                u.add(p);
            }
        }

        List<Map.Entry<Integer, String>> a = new ArrayList<>();

        for (Map.Entry<Integer, String> s : u) {
            if (a.isEmpty() || q(a.get(0).getValue()).length() > q(s.getValue()).length()) {
                a.clear();
                a.add(new AbstractMap.SimpleEntry<>(s.getKey(), q(s.getValue())));
            } else if (a.get(0).getValue().length() == s.getValue().length()) {
                a.add(s);
            }
        }

        Map.Entry<Integer, String> d = null;
        for (Map.Entry<Integer, String> g : a) {
            if (d == null || d.getKey() > g.getKey()) {
                d = g;
            }
        }


        int v = 0;
        for (Map.Entry<Integer, String> h : K.entrySet()) {
            if (h.getValue().contains(String.valueOf(d.getValue().charAt(0)))) {
                v = h.getKey();
            }
        }
        String b = K.get(v);

        Character[] x = d.getValue().chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(x, (o1, o2) -> b.indexOf(o1) - b.indexOf(o2));


        String n = "";

        for (Character c : x)
            n += c.toString();


        System.out.print(n);
    }

    private static String q(final String input) {
        String a = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (a.indexOf(c) == -1) {
                a += c;
            }
        }
        return a;
    }

}
