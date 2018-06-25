	static void f(String s) {
		String[] x = { "123", "456", "789", "147", "258", "369","159","357" };
		String p = "", r = "";
		for (int i = 0; i < s.length(); i++) {
			Integer a = Integer.valueOf(s.substring(i, i + 1));
			if (i % 2 == 0) {
				p += a;
			} else {
				r += a;
			}
			for (String u : x) {
				if (c(p, u)) {
					System.out.println("O");return;
				}
				if (c(r, u)) {
					System.out.println("X");return;
				}
			}
		}
		System.out.println("?");
	}

	static boolean c(String s, String a) {
		for (char c : a.toCharArray()) {
			if (!s.contains("" + c)) {
				return false;
			}
		}
		return true;
	}
