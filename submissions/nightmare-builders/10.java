	static void f(int toLit, String scene) {
		int lit = 0;
		int torch = 0;
		String[] split = scene.split("\n");
		int[] toChange = new int[1000];
		int toChangeIndex = 0;
		for (int x = 0; x < split[0].length(); x++) {
			String t = "";
			int balance = 0;
			for (int i = 0; i < split.length; i++) {
				char c = split[split.length - i - 1].charAt(x);
				balance += (c == '/' ? 1 : c == '\\' ? -1 : 0);
				if (balance > 1 || balance < -1) {
					balance = 9;
				}
				t += c;
			}
			lit += balance == 0 && t.matches("^[X]+[\\\\/\\|]+(\\$)[^X\\\\/\\.\\$]*$") ? 1 : 0;
			boolean isTorch = balance == 0 && t.matches("^[X]+[\\\\/\\|]+(\\.)[^X\\\\/\\.\\$]*$");
			torch += isTorch ? 1 : 0;
			if (isTorch) {
				toChange[toChangeIndex++] = (split.length - t.indexOf('.') - 1) * (split[0].length() + 1) + x;
			}
		}
		if (lit + torch == 0) {
			System.out.println(":(");
		} else if (toLit > lit + torch) {
			System.out.println(toLit - lit - torch);
		} else if (toLit < lit) {
			System.out.println(toLit - lit);
		} else {
			for (int i = 0; i < toLit - lit; i++) {
				scene = scene.substring(0, toChange[i]) + '$' + scene.substring(toChange[i] + 1, scene.length());
			}
			System.out.println(scene);
		}
	}