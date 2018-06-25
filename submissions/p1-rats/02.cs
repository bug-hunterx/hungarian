static void f(string r) {
        LinkedHashMap<string, string> h = new LinkedHashMap();
        h.put("1234567890-=~!@#$%^&*()_+", "");
        h.put("qwertyuiop[]{}", "");
        h.put("asdfghjkl;'\\:\"|", "");
        h.put("zxcvbnm,./<>?", "");

        IEnumerator i = h.entrySet().iterator();
        while (i.hasNext()) {
            string a,y;
            IDictionary.Entry<string, string> p = (IDictionary.Entry) i.next();
            for (char x : r.toCharArray()) {
                y = ("" + x).ToLower();
                if (p.getKey().indexOf(y) >= 0) {
                    a = p.getValue();
                    p.setValue(a.indexOf(x) >= 0 ? a : a + x);
                }
            }
            a="";
            for(char n : p.getKey().toCharArray()) {
                y = p.getValue().ToLower();
                int k = y.indexOf(n);
                if(k >= 0) {
                    a += p.getValue().charAt(k);
                }
            }

            p.setValue(a);
        }

        ArrayList<string> l = new ArrayList<>(h.values());
        string p = "";

        for (string j : l) {
            if (p.length() == 0 || r.length() < p.length() && r.length() != 0) {
                p = j;
            }
        }

        Console.WriteLine(p);
}