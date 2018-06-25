/**
 * Created by pozo on 2016.01.16..
 */
public class App {
    private static String f0 =
        "    *   *     \n" +
        " *     *     *\n" +
        "   *      *  .\n" +
        "     .  $    /\n" +
        " . . /  | $  \\\n" +
        " | | \\  | |  |\n" +
        " X X X  X X  X";
    private static String f1 =
        "*    *  .   \n" +
        "   ~ .  \\   \n" +
        "  .  |  |  $\n" +
        "  |  X  /  |\n" +
        "  X     X  X";
    private static String f3 =
        ".\n" +
        "|\n" +
        "X";
    private static String f2 =
        "    .  \n" +
        "  . \\  \n" +
        "$ | | $\n" +
        "| X / |\n" +
        "X   X X";
    private static String scene =
        "     *   *     \n" +
        "  *     *     *\n" +
        "    *      *  .\n" +
        ".     .  $    /\n" +
        "| . . /  | $  \\\n" +
        "X | | \\  | |  |\n" +
        "  X X X  X X  X";

    private static String scene2 = "           \n";

    private static String scene3 =
            "    #   \n" +
            "  . \\  \n" +
            "$ | | $ \n" +
            "| X / ! \n" +
            "    X X \n";

    private static String scene4 =
        "     *   *      \n" +
        "  *     *     * \n" +
        "    *      *  . \n" +
        "      .  $    /.\n" +
        ". .$. /  | $  \\|\n" +
        "| ||| \\  | |  |X\n" +
        "X XXX X  X X  X ";
    private static String mazeltov =
        "          \n" +
        "  $     . \n" +
        "  |.   .| \n" +
        "  ||...|| \n" +
        "  ||||||| \n" +
        "  ||||||| \n" +
        "  ||||||| \n" +
        "  XXXXXXX  ";
    private static String scene5 =
            "X    *    \n" +
            "   *  X  *\n" +
            "    * X   \n" +
            ".í    ..ö \n" +
            "|é ő.+/  |\n" +
            "X..*|?\\   \n" +
            "  X X X   ";

    private static String scene6 = "\n";

    public static void main(String[] args) {
        f(2,f1);
        f(5,f2);
        f(1,f2);
    }
    static void f(int wantToSetFire, String scene)  {
        int width = scene.indexOf("\n")+1;

        int index = -1;

        int burningTorch = 0;
        int notBurningTorch = 0;
        int[] a = new int[scene.length()];
        //List<Integer> readytoFlame = new ArrayList<Integer>();

        index = scene.indexOf("X", index+1);

        int z = 0;
        while(index >= 0) {
            if(index<(scene.length() - width)) {
                index = scene.indexOf("X", index+1);
                continue;
            }
            int characterAbove = index - width;

            int meh = validate(scene, characterAbove, width,false, 0);
            if(meh==-2) {
                burningTorch++;
            } else if(meh>=0) {
                a[z++] = meh;
                //readytoFlame.add(meh);
                notBurningTorch++;
            }
            index = scene.indexOf("X", index+1);
        }

        int torchNumber = burningTorch + notBurningTorch;

        if(torchNumber == 0) {
            System.out.println(":(");
        } else if(wantToSetFire > torchNumber) {
            System.out.println(wantToSetFire - torchNumber);

        } else if(wantToSetFire < burningTorch) {

            System.out.println(wantToSetFire - burningTorch);

        } else {
            for (int i = 0; i < wantToSetFire - burningTorch; i++) {
                StringBuilder newScene = new StringBuilder(scene);
                newScene.setCharAt(a[i],'$');
                scene = newScene.toString();
            }
            System.out.println(scene);
        }
    }
    void s(String a) {
        System.out.println(a);
    }
    static int validate(String str, int startIndex, int step, boolean hasbody, int balance) {
        char charAt = str.charAt(startIndex);
        if (charAt == '|') {
            return validate(str, startIndex-step, step,true ,balance);
        } else if(charAt == '\\'&& balance <= 0) {
            return validate(str, startIndex-step, step,true,++balance);
        } else if(charAt == '/' && balance >= 0) {
            return validate(str, startIndex-step, step,true,--balance);
        } else if(charAt == '.' && (hasbody && balance == 0)) {
            return startIndex;
        } else if(charAt == '$' && hasbody && balance == 0) {
            return -2;
        } else {
            return -1;
        }
    }
}
