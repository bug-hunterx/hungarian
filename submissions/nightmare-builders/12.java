	static boolean h = true;
	static boolean w = true;

	
	static void f(String scene, int width, int height) {
		Set<Integer> last = new HashSet<>();
		int x = 0;
		int y = 0;
		 
		int dir = 2;
		while (true) {
			int coord = x * 1000000 + y * 1000 + dir;
			if (!last.add(coord)) {
				System.out.println(8);
				return;
			}
			last.add(coord);
			String gather = new String(getActual(scene, width, height, x, y));
			dir = direction(gather, dir);
			x += dir / 2;
			y += - dir % 2;
			if (dir == 0) {
				System.out.println(9);
				return;
			}
		}
		
		
	}
 	
	static char[] getActual(String scene, int width, int height, int x, int y) {
		String[] rows = scene.split("\n");
		char[] actual = new char[width*height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				try {
					actual[j * width + i] = rows[j + y].charAt(i + x);
				} catch (Exception e) { actual[j * width + i] = ' ';}
			}
		}
		return actual;
	}
	
	/*
	 * 1 up         1
	 * 2 right      2
 	 * 3 down      -1
	 * 4 left      -2
	 */
	static int direction(String chars, int lastDir) {
		int right = chars.replaceAll("[^>]*", "").length();
		int left = chars.replaceAll("[^<]*", "").length();
		int down = chars.replaceAll("[^v]*", "").length();
		int up = chars.replaceAll("[^\\^]*", "").length();
		int stopH = chars.replaceAll("[^h]*", "").length();
		int startH = chars.replaceAll("[^H]*", "").length();
		int stopV = chars.replaceAll("[^w]*", "").length();
		int startV = chars.replaceAll("[^W]*", "").length();
		
		int horizontalSum = left - right;
		int verticalSum = up - down;
		int verticalMove = startV - stopV;
		int horizontalMove = startH - stopH;
		
		if (verticalMove < 0) {
			w = false;
		}
		if (verticalMove > 0) {
			w = true;
		}

		if (horizontalMove < 0) {
			h = false;
		}
		if (horizontalMove > 0) {
			h = true;
		}
		
		
		if (!w) {
			verticalSum = 0;
		}
		if (!h) {
			horizontalSum = 0;
		}
		if (horizontalSum != 0 && Math.abs(horizontalSum) == Math.abs(verticalSum)) {
			if (lastDir / 2 != 0) {
				verticalSum = 0;
			} else {
				horizontalSum = 0;
			}
		}
		if (Math.abs(horizontalSum) > Math.abs(verticalSum)) {
			return horizontalSum > 0 ? -2 : 2; 
		} else if (Math.abs(verticalSum) > Math.abs(horizontalSum)) {
			return verticalSum > 0 ? 1 : -1; 
		}
		return 0;
	}