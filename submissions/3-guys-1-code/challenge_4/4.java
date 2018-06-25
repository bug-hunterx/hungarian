	static void f(String game) {
		int[] rows = new int[3];
		int[] cols = new int[3];
		int[] diags = new int[2];
		String diag1="159";
		String diag2="357";
		int toAdd = -1;
		char res = '?';
		for (char ch : game.toCharArray()) {
			int x = ((int) ch) - 49;
			if (diag1.contains(ch+"")) {
				diags[0]+=toAdd;
			}
			if (diag2.contains(ch+"")) {
				diags[1]+=toAdd;
			}
			cols[x % 3] += toAdd;
			rows[x / 3] += toAdd;
			if (rows[x / 3] == -3 || cols[x % 3] == -3 || diags[0]==-3|| diags[1]==-3) {
				res = 'O';
				break;
			} else if (rows[x / 3] == 3 || cols[x % 3] == 3|| diags[0]==3|| diags[1]==3) {
				res = 'X';
				break;
			}
			toAdd *= -1;
		}
		System.out.println(res);
	}