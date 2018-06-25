package hu.epam.hackaton.noteamfoundexception.theApplication;

public class C12Runnable {

    static char[][] p;
    static int width, height;
    static int uWidth, uHeight;

    static void f(String s, int w, int h) {
        width = w;
        height = h;
        int x = 0, y = 0;

        String[] sp = s.split("\n");
        uHeight = sp.length;
        uWidth = sp[0].length();
        p = new char[uHeight][uWidth];
        int k = 0;
        for (String line : sp) {
            p[k++] = line.toCharArray();
//            System.out.println(line.toCharArray());
        }

        int deltaX = 1;
        int deltaY = 0;
        int i = 0;
        boolean exit = false;
        while (!exit && i < 30) {
            int retDeltaX = deltaX(x, y);
            int retDeltaY = deltaY(x, y);

            if (Math.abs(retDeltaX) > Math.abs(retDeltaY)) {
                deltaX = (retDeltaX / Math.abs(retDeltaX));
                deltaY = 0;
            } else if (Math.abs(retDeltaX) < Math.abs(retDeltaY)) {
                deltaX = 0;
                deltaY = (retDeltaY / Math.abs(retDeltaY));
            }
            
            if (deltaX == 0 && deltaY == 0) {
                return;
            }
            
            x = x + deltaX;
            y = y + deltaY;
//            System.out.println();
//            System.out.println("x : " + x);
//            System.out.println("y : " + y);
            
            exit = x == 0 && y == 0;
            i++;
        }

        if (i < 30) {
            System.out.println("8");
        } else {
            System.out.println("9");
        }
    }

    static int deltaX(int x, int y) {
        int h = 0;
        int r = 0;
        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {
                if (i >= 0 && i < uHeight && j >= 0 && j < uWidth) {
                    if (p[i][j] == '<')
                        r--;
                    if (p[i][j] == '>')
                        r++;
                    if (p[i][j] == 'h')
                        h--;
                    if (p[i][j] == 'H')
                        h += 10;
                }
            }
        }

        return h < 0 ? 0 : r;
    }

    static int deltaY(int x, int y) {
        int w = 0;
        int u = 0;
        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {
                if (i >= 0 && i < uHeight && j >= 0 && j < uWidth) {
                    if (p[i][j] == '^')
                        u--;
                    if (p[i][j] == 'v')
                        u++;
                    if (p[i][j] == 'w')
                        w--;
                    if (p[i][j] == 'W')
                        w += 10;
//                    System.out.print(p[i][j]);
                }
            }
//            System.out.println();
        }

        return w < 0 ? 0 : u;
    }

    public static void main(String args[]) {
        f(">v>v>v\n^v^v^v\n^v^v^v\n^>^>^v\n^<<<<<", 6, 5);
    }
}
