	static void f(String s) {
		String[] m = { "[" + Pattern.quote("`1234567890-=~!@#$%^&*()_+") + "]", "[qwertyuiop\\[\\]QWERTYUIOP\\{\\}]",
				"[asdfghjkl;'\\\\ASDFGHJKL:\"\\|]", "[\\\\zxcvbnm,\\.\\|ZXCVBNM\\<\\>\\?]" };

		String r = s;
		String r1 = s;
		int rp = 0;
		for (int i = 0; i < m.length; i++) {
			String p = s;
			for (int j = 0; j < m.length; j++) {
				if (i != j) {
					p = p.replaceAll(m[j], "");
				}
			}

			if (p.length() > 0) {
				// remove duplicated chars
				String pm = "";
				for (int k = 0; k < p.length(); k++) {
					if (!pm.contains("" + p.charAt(k))) {
						pm += "" + p.charAt(k);
					}
				}

				// find actual pattern
				int ap = 0;
				for (int l = 0; l < m.length; l++) {
					if (pm.substring(0, 1).matches(m[l])) {
						ap = i;
					}
				}

				// find least chars
				if (r.length() > p.length() | r1.length() > pm.length() | (r.length() == pm.length() && ap < rp)) {
					r = p;
					r1 = pm;
					rp = ap;
				}
			}
		}
		// print it in keyboard order

		String[] k2 = { "`1234567890-=~!@#$%^&*()_+", "qwertyuiop[]QWERTYUIOP{}", "asdfghjkl;'\\ASDFGHJKL:\"|",
				"zxcvbnm,./ZXCVBNM<>?" };
		for (char c : k2[rp].toCharArray()) {
			if (r.indexOf(c) > -1) {
				System.out.print(c);
			}
		}
		System.out.println();
	}