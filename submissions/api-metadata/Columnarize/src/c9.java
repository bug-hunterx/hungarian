
public class c9 {

    public static void main(String args[]) {
        f("piranha  fsf Princess   piranha");
        f("1Up koopa goomba piranha Bowser");
        f("Star Mushroom piranha goomba piranha goomba Princess");
        f("piranha piranha piranha piranha");
        f("piranha piranha Star goomba goomba Princess");
        f("Star 1Up 10 40 koopa goomba 20 29 piranha piranha");
        f("koopa 1Up goomba piranha 100 piranha 50 1Up 20 koopa 10 30 piranha 20 40 60 piranha Princess");
    }

    private static void f(String q) {
        int l = 3, i = 0, c = 0;
        boolean d = false, j = false, w = false, b = false;
        String[] h = q.replaceAll("\\s+", " ").trim().split(" ");
        for (String r : h) {
            switch (r) {
                case "Mushroom":
                    j = true;
                    if (i > 0) i--;
                    break;
                case "1Up":
                    l++;
                    if (i > 0) i--;
                    break;
                case "Star":
                    i = 2;
                    break;
                case "goomba":
                case "koopa":
                case "piranha":
                    if (i == 0) {
                        if (j) j = false;
                        else if (l > 1) l--;
                        else d = true;
                    }
                    if (i > 0) i--;
                    break;
                case "Bowser":
                case "Princess":
                    w = true;
                    break;
                default:
                    try {
                        c += Integer.valueOf(r);
                        if (c >= 100) {
                            l++;
                            c -= 100;
                        }
                        if (i > 0) i--;
                    } catch (Exception e) {
                        b = true;
                    }
            }
            if (w) {
                System.out.println("WIN");
                break;
            }
            if (d) {
                System.out.println("GAME OVER");
                break;
            }
            if (b) break;
        }
        if (!d && !w) System.out.println("???");
    }
}