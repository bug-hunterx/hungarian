static void f(String s)
{
	Map<Character, F> fM = new HashMap<>();
	for (char c : s.toCharArray())
	{
		F f = fM.get(c);
		fM.put(c, new F(1 + (f == null ? 0 : f.f), c));
	}
	List<F> fs = new ArrayList<>(fM.values());
	Collections.sort(fs, (x, y) -> {
		int d = x.f - y.f;
		return d == 0 ? x.c - y.c : d;
	});
	fs.stream().flatMap(f -> Stream.generate(() -> f.c).limit(f.f)).forEach(System.out::print);
}

static class F
{
	int f;
	char c;

	F(int f, char c)
	{
		this.f = f;
		this.c = c;
	}
}