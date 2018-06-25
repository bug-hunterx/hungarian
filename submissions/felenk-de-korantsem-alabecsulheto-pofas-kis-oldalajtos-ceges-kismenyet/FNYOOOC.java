static void f(String s, int n, int w) {
        int h = (s.length() / w) / n + 1;
        if(h*w*n>s.length())
        for (int i = 0; i < h*w*n - s.length(); i++) s+=" ";
        for (int m = 0; m < h; m++) {
        for (int c = 0; c < n; c++) {
        int v = h * c * w + w * m;

        String o = s.substring(v>s.length()?s.length():v);
        int y = w > o.length() ? o.length() : w;
        System.out.print(o.substring(0, y));
        if (y < w) {
        for (int i = 0; i < w - y; i++) System.out.print(" ");
        }
        if(c!=n-1)System.out.print("|");
        }
        System.out.print('\n');
        }
        }