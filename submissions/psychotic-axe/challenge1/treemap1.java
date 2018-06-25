public static void f(String s) {
	Map<Character, Long> m = new TreeMap<>();
	int l = s.length();
	int i;
	for (i = 0; i < l; i++) {
		Character c = s.charAt(i);
		if (m.containsKey(c)) {
			long v = m.get(c);
			m.remove(c);
			m.put(c, ++v);
		} else {
			m.put(c, 1l);
		}
	}


	String r = "";
	for (i = 0; i < l; i++) {
		long h = (long)i;
		r += m.entrySet().stream().filter(e -> e.getValue() == h).map(e -> new String(new char[e.getValue().intValue()]).replace("\0", e.getKey().toString())).collect(Collectors.joining(""));
	}

	System.out.print(r);
}