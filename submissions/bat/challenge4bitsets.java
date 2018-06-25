static void f(String s)
{
	BitSet O = new BitSet(10);
	BitSet X = new BitSet(10);
	char w = '?';
	for (int i = 0; i < s.length() && w == '?'; i++)
	{
		int p = s.charAt(i) - '1';
		if (i % 2 == 0)
			O.set(p);
		else
			X.set(p);

		w = w(X) ? 'X' : (w(O) ? 'O' : '?');
	}
	System.out.print(w);
}

static BitSet[] w = new BitSet[] {g("111"), g("111000"), g("111000000"), g("100100100"), g("010010010"), g("001001001"), g("100010001"), g("001010100"), g("001001001")};

static BitSet g(String s)
{
	return BitSet.valueOf(new long[]{Long.valueOf(s, 2)});
}

static boolean w(BitSet o)
{
	for (BitSet b : w)
	{
		BitSet s = (BitSet) o.clone();
		s.and(b);
		if (s.equals(b)) return true;
	}
	return false;
}