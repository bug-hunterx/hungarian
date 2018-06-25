import java.util.ArrayList;
import java.util.List;

public class Exec11 {

    public static void main(String[] args) {
        // :D
        String scene1 =
                        "      v  \n" +
                        "> 9 # 9 @\n" +
                        "  #      ";

        // :D
        String scene2 =
                        "    v  \n" +
                        "> 9#9 @\n" +
                        "         ";

        // :/
        String scene3 =
                        "    v   \n" +
                        ">      @\n" +
                        "        \n" +
                        "         ";

        // :(
        String scene4 =
                        "> \\ @\n" +
                        "> \\ @\n" +
                        "> \\ @\n";

        // :/
        String scene5 =
                " @   v @ \n" +
                        "         \n" +
                        ">       @\n" +
                        "         \n" +
                        " ^   @ ^   ";

        // :D
        String scene6 =
                        "         \n" +
                        ">       ^\n" +
                        "           ";

        // :D
        String scene7 =
                        "    v  \n" +
                        ">   9  \n" +
                        "      9  ";

        // :/
        String scene8 =
                        "        \n" +
                        ">    \\ \n" +
                        "        \n" +
                        "     ^    ";

        // :D
        String scene9 =
                        "     v  \n" +
                        "        \n" +
                        ">    \\ \n" +
                        "        \n" +
                        "         ";

        // :D
        String scene10 =
                        "        \n" +
                        ">    \\ \n" +
                        "        \n" +
                        " \\  /    ";

        // :)
        String scene11 =
                        "         /   @\n" +
                        "              \n" +
                        ">  9          \n" +
                        "      9  /    \n" +
                        "                ";
        // :/
        String scene12 =
                        "   v    \n" +
                        ">    \\ \n" +
                        "        \n" +
                        " \\  /    ";

        // :/
        String scene13 =
                        "    \n" +
                        ">\\ \n" +
                        " ^    ";



//        f(scene1);
//        f(scene2);
//        f(scene3);
//        f(scene4);
//        f(scene5);
//        f(scene6);
//        f(scene7);
//        f(scene8);
//        f(scene9);
//        f(scene10);
//        f(scene11);
//          f(scene12);
          f(scene13);
    }


    static String[] map;
    static List<Position> enemies;
    static List<Beam> mirrors;
    static String[] beams;
    static String[][] orient;
    static int width;
    static int height;

    static void f(String scene) {
        map = scene.split("\n");
        height = map.length;
        width = map[0].length();
        beams = new String[height];
        //orient = new String[height][width] ;
        enemies = new ArrayList<>();
        mirrors = new ArrayList<>();
        orient = new String[height+100][width+100];
        for (int i = 0; i < height; i++) {
            beams[i] = String.valueOf(new char[width]);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                orient[i][j] = "";
            }
        }


        char turretNR = 1;
        int nrOfEnemies = 0;
        for (int y = 0; y < map.length; y++) {
            String m = map[y];
            for (int x = 0; x < m.length(); x++) {
                char c = m.charAt(x);
                if (isTurret(c)) {
                    fire(x, y, turretNR++);
                }
                if (c == '@') {
                    nrOfEnemies++;
                }
            }
        }
        if (nrOfEnemies == enemies.size()) {
            System.out.println(":D");
        }
        if (nrOfEnemies > enemies.size()) {
            System.out.println(":(");
        }
    }

    private static void fire(int x, int y, char turretNr) {
        Position pos = new Position();
        pos.x = x;
        pos.y = y;
        pos.d = getTurretDirection(map[y].charAt(x));
        Position currentPos = getNextPosition(pos);
        checkPosition(currentPos);
        while (!currentPos.isLast) {
            checkPosition(currentPos);
            if (!currentPos.isLast) {
                checkBean(currentPos, turretNr);
                currentPos = getNextPosition(currentPos);
            }
        }
    }

    private static void checkBean(Position pos, char nr) {
        if (pos.y >= beams.length || pos.x >= beams[pos.y].length()) {
            pos.isLast = true;
        } else {
            char c1 = beams[pos.y].charAt(pos.x);
                char nul ='\u0000' ;
            if (c1 != nul && c1 < nr) {
                System.out.println(":/");
                System.exit(0);
            }
            char c = map[pos.y].charAt(pos.x);
            if (!(isTurret(c) || c == '\\' || c == '/' || number(c))) {
                char[] a = beams[pos.y].toCharArray();
                a[pos.x] = nr;
                beams[pos.y] = String.valueOf(a);
            }
            if (c == '\\') {
                if (pos.d == "E" || pos.d == "N" && beams[pos.y].charAt(pos.x) < nr ){
                    if(orient[pos.x][pos.y] == "UP"){
                        System.out.println(":/");
                        System.exit(0);
                    }
                    orient[pos.x][pos.y] = "UP";
                }
                if (pos.d == "W" || pos.d == "S" && beams[pos.y].charAt(pos.x) < nr ){
                    if(orient[pos.x][pos.y] == "DOWN"){
                        System.out.println(":/");
                        System.exit(0);
                    }
                    orient[pos.x][pos.y] = "DOWN";
                }

            }
            if (c == '/') {
                if (pos.d == "W" || pos.d == "N" && beams[pos.y].charAt(pos.x) < nr ){
                    if(orient[pos.x][pos.y] == "UP"){
                        System.out.println(":/");
                        System.exit(0);
                    }
                    orient[pos.x][pos.y] = "UP";
                }
                if (pos.d == "E" || pos.d == "S" && beams[pos.y].charAt(pos.x) < nr ){
                    if("DOWN".equals(orient[pos.x][pos.y])){
                        System.out.println(":/");
                        System.exit(0);
                    }
                    orient[pos.x][pos.y] = "DOWN";
                }

            }
        }
    }


    private static Position getNextPosition(Position pos) {
        String d = pos.d;
        int x = pos.x;
        int y = pos.y;
        Position next = new Position();
        next.x = x;
        next.y = y;
        d = getDirection(d, map[y].charAt(x), map[y]);
        if (number(map[y].charAt(x))) {
            Position portal = getPortal(x, y);
            portal.d = d;
            next = getPortalPosition(portal);
            x = next.x;
            y = next.y;
            return next;
        }
        if ('#' == map[y].charAt(x)) {
            next.isLast = true;
            return next;
        }
        if ("W".equals(d)) {
            if (x > 0) {
                next.x = x - 1;
            } else {
                next.x = x;
                next.isLast = true;
            }
        }
        if ("E".equals(d)) {
            if (x < width - 1) {
                next.x = x + 1;
            } else {
                next.x = x;
                next.isLast = true;
            }
        }
        if ("N".equals(d)) {
            if (y > 0) {
                next.y = y - 1;
            } else {
                next.y = y;
                next.isLast = true;
            }
        }
        if ("S".equals(d)) {
            if (y < height - 1) {
                next.y = y + 1;
            } else {
                next.y = y;
                next.isLast = true;
            }
        }
        next.d = d;
        return next;
    }

    private static Position getPortalPosition(Position pos) {
        String d = pos.d;
        int x = pos.x;
        int y = pos.y;
        Position next = new Position();
        next.x = x;
        next.y = y;
        d = getDirection(d, map[y].charAt(x), map[y]);
        if ('#' == map[y].charAt(x)) {
            next.isLast = true;
        }
        if ("W".equals(d)) {
            if (x > 0) {
                next.x = x - 1;
            } else {
                next.x = x;
                next.isLast = true;
            }
        }
        if ("E".equals(d)) {
            if (x < width) {
                next.x = x + 1;
            } else {
                next.x = x;
                next.isLast = true;
            }
        }
        if ("N".equals(d)) {
            if (y > 0) {
                next.y = y - 1;
            } else {
                next.y = y;
                next.isLast = true;
            }
        }
        if ("S".equals(d)) {
            if (y < height) {
                next.y = y + 1;
            } else {
                next.y = y;
                next.isLast = true;
            }
        }
        next.d = d;
        return next;
    }

    private static String getDirection(String d, char c, String s) {
        if ('\\' == c) {
            switch (d) {
                case "E":
                    d = "S";
                    break;
                case "N":
                    d = "W";
                    break;
                case "W":
                    d = "N";
                    break;
                default:
                    d = "E";
                    break;
            }
        }
        if ('/' == c) {
            switch (d) {
                case "E":
                    d = "N";
                    break;
                case "N":
                    d = "E";
                    break;
                case "W":
                    d = "S";
                    break;
                default:
                    d = "W";
                    break;
            }
        }
        return d;
    }

    private static void checkPosition(Position next) {
        int x = next.x;
        int y = next.y;
        if (y < map.length && x < map[y].length()) {
            if (isTurret(map[y].charAt(x))) {
                next.isLast = true;
                return;
            }
            if (map[y].charAt(x) == '@') {
                Position p = new Position();
                p.x = x;
                p.y = y;
                enemies.add(p);
                next.isLast = true;
            }
        } else {
            next.isLast = true;
        }
    }

    private static Position getPortal(int old_x, int old_y) {
        Position p = new Position();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length(); x++) {
                if (number(map[y].charAt(x))) {
                    if (x != old_x || y != old_y) {
                        p.x = x;
                        p.y = y;
                    }
                }
            }
        }
        return p;
    }

    static boolean number(char c){
        if (c =='0'|| c =='1'|| c =='2'|| c =='3'|| c =='4'|| c =='5'|| c =='6'|| c =='7'|| c =='8'|| c =='9'){
            return true;
        }
        return false;
    }

    private static String getTurretDirection(char c) {
        if (c == '<') return "W";
        if (c == '>') return "E";
        if (c == '^') return "N";
        return "S";
    }

    static boolean isTurret(char c) {
        char[] turrets = new char[]{'<', '>', '^', 'v'};
        for (char turret : turrets) {
            if (c == turret) {
                return true;
            }
        }
        return false;
    }

    static class Position {
        String d;
        public int x;
        public int y;
        public boolean isLast;
    }

    static class Beam {
        public int x;
        public int y;
        public String orientation;
    }

}
