static void f(String s) {

		StringBuilder dominos = new StringBuilder();
		dominos.append(s);
		char leftToMe = ' ';
		char me = dominos.charAt(0);
		char rightToMe = ' ';
		for (int z = 0; z < (dominos.length() / 2) - 1; z++) {
			for (int i = 0; i < dominos.length() - 1; i++) {
				for (int k = 0; k < 2; k++) {

					int j = i;

					if (k == 1) {
						j = dominos.length() - 2 - i;
					}

					if (dominos.charAt(dominos.length() - 1) == '/') {
						dominos.append(' ');
					}

					me = dominos.charAt(j);
					if (j != 0) {
						leftToMe = dominos.charAt(j - 1);
					}
					if (j < dominos.length()) {
						rightToMe = dominos.charAt(j + 1);
					}
					if (me == ' ') {
						if (leftToMe == '/') {
							dominos.setCharAt(j, '_');
							dominos.setCharAt(j - 1, '_');
						} else if (rightToMe == '\\') {
							dominos.setCharAt(j, '_');
							dominos.setCharAt(j + 1, '_');
						}
					} else

					if (me == '/') {
						if (rightToMe == ' ') {
							dominos.setCharAt(j, '_');
							dominos.setCharAt(j + 1, '_');
						}
					} else

					if (me == '\\') {
						if (j == 0) {
							dominos.insert(0, ' ');
						}

						if (leftToMe == ' ' && j > 1) {
							if (dominos.charAt(j - 2) != '/') {

								dominos.setCharAt(j, '_');
								dominos.setCharAt(j - 1, '_');

							}
							if (dominos.charAt(j - 2) == '/') {

								dominos.setCharAt(j, '\\');

							}
						}
						if (leftToMe == '_') {
							dominos.setCharAt(j, '\\');
						}

					} else

					if (me == '|') {
						if (leftToMe == '/' && rightToMe == '\\') {
							dominos.setCharAt(j, '|');
						} else if (leftToMe == '/') {
							if (j == dominos.length() - 2) {
								dominos.append(' ');
							}
							if (rightToMe == ' ') {
								dominos.setCharAt(j, '_');
								dominos.setCharAt(j + 1, '_');
							} else if (rightToMe == '\\' && (dominos.length() % 2) != 0) {
								dominos.setCharAt(j, '|');
							} else {
								dominos.setCharAt(j, '/');
							}
						} else if (rightToMe == '\\') {
							if (leftToMe == ' ') {
								dominos.setCharAt(j, '_');
								dominos.setCharAt(j - 1, '_');

							} else {
								dominos.setCharAt(j, '\\');
							}
						}

					}

				}
			}

		}
		System.out.print(dominos);

	}