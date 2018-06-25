	static void f(String storyboard) {
		int balance = 0;
		int lifes = 3;
		int invulnerability = 0;
		boolean superM = false;
		String[] steps = storyboard.split(" +");
		for (int i = 0; i < steps.length; i++) {
			String step = steps[i];
			if (step.matches("\\d+")) {
				balance+=Integer.parseInt(step);
				while (balance > 100) {
					balance-=100;
					lifes++;
				}
					
			}
			else if (step.matches("goomba|koopa|piranha")) {
				if (invulnerability == 0) {
					if (superM) {
						superM = false;
					}
					else {
						lifes--;
					}
				}

			}
			else if ("Mushroom".equals(step)) {
				superM = true;
			}
			else if ("Star".equals(step)) {
				invulnerability = 3;
			}
			else if ("1Up".equals(step)) {
				lifes++;
			}
			else if (step.matches("Bowser|Princess") ) {
				finish("WIN");
			}
			if (lifes == 0) {
				finish("GAME OVER");
			}
			invulnerability = invulnerability > 0 ? --invulnerability : invulnerability;
		}
		finish("???");
	}
	
	static void finish(String s) {
		System.out.println(s);
		System.exit(0);
	}