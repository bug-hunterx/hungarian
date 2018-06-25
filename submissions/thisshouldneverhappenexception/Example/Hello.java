static void f(int i, String s, double l, String file, char c, int count)  {

	String print = "" + i + s + l + file + c + "\n";

	for(int j=0; j<count; j++) {
		System.out.print(print);
	}
}
