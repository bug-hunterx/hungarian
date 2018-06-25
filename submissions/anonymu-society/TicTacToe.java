public class TicTacToe {

    public static void main(String[] a) {
        f("5237649"); // -> O
        f("523764918"); // -> O
        f("352476"); // -> X
        f("4268379"); // -> O
        f("631854792"); // -> ?
        f("523764918"); // -> O
        f("457281369"); // -> O  #11
    }

    static void f(String s) {
        System.err.println(s);
        String res = "?";

        // Parse input
        int[] grid = new int[9];

        int playa = 1; // O == 1, X == 2

        mainloop:
        for (int i = 0; i < s.length(); i++) {
            int idx = Integer.parseInt(String.valueOf(s.charAt(i)));
            grid[idx-1] = playa;

            playa = (playa == 1 ? 2 : 1);

            // check winner
            int h1 = 0;
            int h2 = 0;
            int[] v1 = new int[3];
            int[] v2 = new int[3];

            for (int j = 0; j < 9; j++) {

                // Simple horizontal checking
                if (grid[j] == 1) {
                    h1++;
                } else if (grid[j] == 2) {
                    h2++;
                }

                if (h1 == 3) {
                    res = "O";
                    break mainloop;
                } else if (h2 == 3) {
                    res = "X";
                    break mainloop;
                }

                // horiz reset
                if (j % 3 == 2) {
                    h1 = 0;
                    h2 = 0;
                }

                // Vertical checking
                if (grid[j] == 1) {
                    v1[j % 3]++;
                } else if (grid[j] == 2) {
                    v2[j % 3]++;
                }

                for (int k = 0; k < 3; k++) {
                    if (v1[k] == 3) {
                        res = "O";
                        break mainloop;
                    } else if (v2[k] == 3) {
                        res = "X";
                        break mainloop;
                    }
                }

            }

            // Diagonal checking
            if ((grid[0] == 1 && grid[4] == 1 && grid[8] == 1) ||
                    (grid[2] == 1 && grid[4] == 1 && grid[6] == 1)) {
                res = "O";
                break mainloop;
            } else if ((grid[0] == 2 && grid[4] == 2 && grid[8] == 2) ||
                        (grid[2] == 2 && grid[4] == 2 && grid[6] == 2)) {
                res = "X";
                break mainloop;
            }

        }
        //System.out.println();

        // TODO: rem
        for (int i = 0; i < 9; i++) {
            System.out.print(grid[i]);
        }
        System.out.println("\n---");

        for (int i = 0; i < 9; i++) {
            System.out.print(grid[i]);
            if (i % 3 == 2) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.println(res);
        System.out.print();
    }

}
