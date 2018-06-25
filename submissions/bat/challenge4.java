static void f(String s)
{
	int[] x = new int[10];
	int[] o = new int[10];
	char w = '?';
	for (int i = 0; i < s.length() && w == '?'; i++)
	{
		int p = s.charAt(i) - '0';
		if (i % 2 == 0)
			o[p] = 1;
		else
			x[p] = 1;

		w = w(x) ? 'X' : (w(o) ? 'O' : '?');
	}
	System.out.print(w);
}

static int[][] winnerPositions = new int[][] {
	{0,1,1,1,0,0,0,0,0,0},
	{0,0,0,0,1,1,1,0,0,0},
	{0,0,0,0,0,0,0,1,1,1},
	{0,1,0,0,1,0,0,1,0,0},
	{0,0,1,0,0,1,0,0,1,0},
	{0,0,0,1,0,0,1,0,0,1},
	{0,1,0,0,0,1,0,0,0,1},
	{0,0,0,1,0,1,0,1,0,0}
};

private static boolean w(int[] i)
{
	for (int[] p : winnerPositions)
	{
		int[] ic = Arrays.copyOf(i, i.length);
		for (int j = 0; j < i.length; j++)
		{
			ic[j] &= p[j];
		}

		if (Arrays.equals(ic, p)) return true;
	}
	return false;
}