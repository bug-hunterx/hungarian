static void f(int cost) {
		int tip = -1;
		int rounded = -1;
		int rounded2 = -1;
		int percent = -1;
		if (cost < 2000) {
			rounded = ((cost + 99) / 100) * 100;
			tip = rounded - cost;
		} else if (cost < 5000) {
			rounded = 500 * Math.round(cost / 500);
			rounded2 = (int) (cost / 1000.0 + .5) * 1000;
			if (Math.abs(rounded - cost) > Math.abs(rounded2 - cost)) {
				tip = rounded2 - cost;
				rounded = rounded2;
			}
			tip = rounded - cost;
		} else {
			percent = (int) ((cost * 100.0f) / 1000);
			int costWithPercent = (cost + percent);
			// System.err.println("costWithPercent " + costWithPercent);
			rounded = 500 * Math.round(costWithPercent / 500);
			rounded2 = (int) (costWithPercent / 1000.0 + .5) * 1000;
			// System.err.println("1. rounded " + rounded);
			// System.err.println("2. rounded " + rounded2);
			// System.err.println("1. abs " + Math.abs(rounded -
			// costWithPercent));
			// System.err.println("2. abs " + Math.abs(rounded2 -
			// costWithPercent));
			// System.err.println("tip " + (rounded - costWithPercent));
			if (rounded - costWithPercent != 0) {
				if (Math.abs(rounded - costWithPercent) > Math.abs(rounded2 - costWithPercent)) {
					tip = rounded - costWithPercent;
					rounded = rounded2;
					// System.err.println("++");
				} else {
					tip = rounded - cost;
					// System.err.println("--");
				}
			} else {
				tip = rounded - cost;
			}

		}
		// System.err.println("tip " + tip);
		String message = "";
		if (tip == 0 || tip > 1500) {
			message = "PAID BY CARD";
		} else if (tip < 100) {
			message = "KEEP THE CHANGE YOU FILTY ANIMAL";
		} else {
			message = "HERE IS " + rounded;
		}
		System.out.println(message);
	}