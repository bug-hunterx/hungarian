static void f(String input) {
	int[] letters = new int[256];
	for (char ch : input.toCharArray())
		letters[ch]++;
	String b = "";
	int len = 1;
	while (len < input.length()) {
		for (int i = 0; i < 256; i++)
			if (letters[i] == len) {
				char[] a = new char[len];
				Arrays.fill(a, (char) i);
				b+=new String(a);
			}
		len++;
	}
	System.out.println(b.toString());
}