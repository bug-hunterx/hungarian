public class Domino {

	public static void main(String[] a) {
		f("///|\\\\\\"); // => ///|\\\
		f("| \\\\"); // => |__\
		f("// |"); // => /__|
		f("|/ \\|/ \\|/ \\|/ \\|"); // => |__\|__\|__\|__\|
		f("/||||"); // => ////__
		f("/| /|"); // => /__/__
		f("||\\/||"); // => __\\//__
		f("/||||\\"); // => ///\\\
	}

	static void f(String s) {
		String r = " " + s + " ";

		String chk = r;

		do {
			chk = r;

			r = r.replaceAll("/ ", "__"); // right-tilted with empty next to it fall first
			r = r.replaceAll(" \\\\", "__"); // left-tilted with empty next to it fall next
			r = r.replaceAll("/\\|\\|\\\\", "//\\\\\\\\"); // force arrives from 2 directions in the same time (exceptional case)
			r = r.replaceAll("(/\\|)([^\\\\])", "//$2"); // push from left
			r = r.replaceAll("([^/])(\\|\\\\)", "$1\\\\\\\\"); // push from right

		} while (!chk.equals(r));  // do until dominoes rest finally in a steady state

		System.out.println(r.trim());
//		System.out.print(s + " => " + r);
//		System.out.println();
	}

}
