public static void f(String s) {
	char[] moves = s.toCharArray();

	int[] moves2 = new int[9];
	for (int j = 0; j < moves.length; j++) {
		moves2[Integer.parseInt(moves[j]+"")-1] = j % 2 + 1;
	}
	boolean end = false;
	for (int i = 5; i < moves.length; i++) {
		for (int j = 1; j <= 2; j++) {
			boolean win =
			check(moves2, 0, 1, 2, j)
			|| check(moves2, 3, 4, 5, j)
			|| check(moves2, 6, 7, 8, j)
			|| check(moves2, 0, 3, 6, j)
			|| check(moves2, 1, 4, 7, j)
			|| check(moves2, 2, 5, 8, j)
			|| check(moves2, 0, 4, 8, j)
			|| check(moves2, 2, 4, 6, j);
			if (win) {
				System.out.println(j == 1 ? "O" : "X");
				end = true;
				break;
			}
		}
		if (end) {
			break;
		}
	}
	if (!end) {
		System.out.println("?");
	}
}

public static boolean check(int[] moves, int first, int second, int third, int player) {
	return moves[first] % 3 == player && moves[second] % 3 == player && moves[third] % 3 == player;
}