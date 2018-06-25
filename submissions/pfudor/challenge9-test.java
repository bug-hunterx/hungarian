    static void f(String i) {
        int s[] = {0, 0, 3, 0};
        Set<String> b = new HashSet<String>();
        b.addAll(Arrays.asList(new String[]{"piranha", "goomba", "koopa"}));
        Set<String> e = new HashSet<String>();
        e.addAll(Arrays.asList(new String[]{"Bowser", "Princess"}));
        String t = "???";
        for (String hap : i.split("\\s+")) {
            if (b.contains(hap) && s[0] < 1) {
                if (s[1] == 0) {
                    s[2]--;
                } else {
                    s[1] = 0;
                }
            } else if (hap.startsWith("M")) {
                s[1] = 1;
            } else if (hap.startsWith("S")) {
                s[0] = 3;
            } else if (hap.startsWith("1")) {
                s[2]++;
            } else if (e.contains(hap)) {
                t = "WIN";
                break;
            } else if (hap.matches("\\d+")) {
                s[3] += Integer.valueOf(hap);
                if (s[3] >= 100) {
                    s[3] = s[3] % 100;
                    s[2]++;
                }
            }
            if (s[2] <= 0) {
                t = "GAME OVER";
                break;
            }
            s[0]--;
        }
        System.out.println(t);
    }